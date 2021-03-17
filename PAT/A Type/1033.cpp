#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

struct station //加油站的结构体
{
    double price, distance;
};

double Cmax, D, Davg;
int N;
station sta[501];

bool cmp(station a, station b) //将所有加油站按距离排序
{
    return a.distance < b.distance;
}

int main()
{
    cin >> Cmax >> D >> Davg >> N;
    for (int i = 0; i < N; i++)
    {
        cin >> sta[i].price >> sta[i].distance;
    }
    sta[N].price = 0;
    sta[N].distance = D;     //将终点作为加油站的形式方便循环处理
    sort(sta, sta + N, cmp); //按距离排序

    if (sta[0].distance != 0) //如果起点位置没有加油站
    {
        cout << "The maximum travel distance = 0.00";
    }
    else
    {
        int now = 0;
        double ans = 0, nowTank = 0, max_dis = Cmax * Davg;
        while (now < N) //循环模拟每一个站
        {
            int k = -1;
            double minP = INT_MAX;
            for (int i = now + 1; i <= N && sta[i].distance - sta[now].distance <= max_dis; i++)
            { //循环判断满油状态下的最长距离中油价最便宜的一个站
                if (sta[i].price < minP)
                {
                    minP = sta[i].price;
                    k = i;
                    if (minP < sta[now].price)
                    {
                        break;
                    }
                }
            }
            if (k == -1) //没找到跳出
            {
                break;
            }
            double need = (sta[k].distance - sta[now].distance) / Davg; //到最便宜站需要加的油
            if (minP <= sta[now].price)                                 //又可以到达价格小于当前的站
            {
                if (nowTank < need) //当前油箱无法到达
                {
                    ans += (need - nowTank) * sta[now].price;
                    nowTank = 0;
                }
                else
                {
                    nowTank -= need;
                }
            }
            else
            {
                ans += (Cmax - nowTank) * sta[now].price;
                nowTank = Cmax - need;
            }
            now = k;
        }
        if (now == N)
        {
            printf("%.2f", ans);
        }
        else
        {
            printf("The maximum travel distance = %.2f", sta[now].distance + max_dis);
        }
    }

    system("pause");
    return 0;
}