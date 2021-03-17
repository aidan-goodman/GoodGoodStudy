#include <cstdio>
#include <cstdlib>

int main()
{
    char c[4] = {"WTL"}; //还应存储一个'\0'表示结束
    double ans = 0.65;   //答案初始为0.65，无需输出时计算
    for (int i = 0; i < 3; i++)
    {
        double maxvalue = 0.0;
        int maxchar = 0;
        for (int j = 0; j < 3; j++)
        {
            double temp;
            scanf("%lf", &temp);
            if (maxvalue <= temp)
            {
                maxvalue = temp;
                maxchar = j;
            }
        }
        ans *= maxvalue;
        printf("%c ", c[maxchar]); //输出符号
    }
    printf("%.2f", (ans - 1) * 2);
    system("pause");
    return 0;
}