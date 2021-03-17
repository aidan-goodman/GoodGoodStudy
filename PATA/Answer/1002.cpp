#include <cstdio>
#include <vector>
#include <cstdlib>
using namespace std;

int main()
{
    vector<double> coef(1001, 0); //根据数据规模，创建浮点数组存储系数
    int cnt = 0;                  //判断最后有多少项
    int m, n;                     //获取每行有多少项
    scanf("%d", &m);
    for (int j = 0; j < m; j++)
    {
        int e_temp;
        double c_temp;
        scanf("%d %lf", &e_temp, &c_temp); //根据项数输入指数和系数
        coef[e_temp] += c_temp;            //用指数作为下标将系数相加
    }
    scanf("%d", &n);
    for (int j = 0; j < n; j++)
    {
        int e_temp;
        double c_temp;
        scanf("%d %lf", &e_temp, &c_temp);
        coef[e_temp] += c_temp;
    }

    for (int i = 0; i < coef.size(); i++)
    {
        if (coef[i])
        { //记录所有不为0的项
            cnt++;
        }
    }
    printf("%d", cnt);
    for (int i = 1000; i >= 0; i--)
    {
        if (coef[i])
        { //不为0便输出指数和系数，注意空格和小数点为1位
            printf(" %d %.1f", i, coef[i]);
        }
    }
    system("pause");
    return 0;
}