#include <cstdio>
#include <vector>
#include <cstdlib>
using namespace std;

int main()
{
    vector<double> coef(1001, 0);
    vector<double> ans(2001, 0); //根据指数最大为1000，相乘后最大的指数为1000+1000
    int cnt = 0;
    int m, n;
    scanf("%d", &m);
    for (int j = 0; j < m; j++)
    {
        int e_temp;
        double c_temp;
        scanf("%d %lf", &e_temp, &c_temp);
        coef[e_temp] += c_temp;
    }
    scanf("%d", &n);
    for (int j = 0; j < n; j++)
    {
        int e_temp;
        double c_temp;
        scanf("%d %lf", &e_temp, &c_temp);
        for (int i = 0; i < coef.size(); i++)
        { //在第二行每输入一项，就与第一行的每项相乘，得到的值根据相同指数加到ans数组中
            if (coef[i])
            {
                ans[i + e_temp] += coef[i] * c_temp;
            }
        }
    }
    for (int i = 0; i < ans.size(); i++)
    {
        if (ans[i])
        {
            cnt++;
        }
    }
    printf("%d", cnt);
    for (int i = 2000; i >= 0; i--)
    {
        if (ans[i])
        {
            printf(" %d %.1f", i, ans[i]);
        }
    }
    system("pause");
    return 0;
}