#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Mooncake
{
    double quality, single_price, total_price; //全国用double型，防止精确度不够
};

int N, D;
bool cmp(Mooncake a, Mooncake b) //按单价排序
{
    return a.single_price > b.single_price;
}

int main()
{
    cin >> N >> D;
    vector<Mooncake> mc(N);
    for (int i = 0; i < N; i++)
    {
        cin >> mc[i].quality;
    }
    for (int i = 0; i < N; i++)
    {
        cin >> mc[i].total_price;
        mc[i].single_price = mc[i].total_price / mc[i].quality;
    }
    sort(mc.begin(), mc.end(), cmp); //输入后按照单价进行排序
    double profit = 0.0;
    int i = 0;
    while (D && i < mc.size()) //注意可能存在所有种类的总量不够需求量的情况
    {
        if (D > mc[i].quality)
        {
            profit += mc[i].total_price; //需求量仍超过当前种类的质量
        }
        else
        {
            profit += D * mc[i].single_price; //不足将剩余量乘单价
            break;
        }
        D -= mc[i].quality; //去掉已经购买的
        i++;                //判断下一组
    }
    printf("%.2f", profit);
    system("pause");
    return 0;
}