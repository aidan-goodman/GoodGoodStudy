#include <cstdio>
#include <cstdlib>

int main()
{
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        long long a, b, c;
        scanf("%lld %lld %lld", &a, &b, &c);
        long long sum = a + b;
        if (a > 0 && b > 0 && sum < 0)
        { //正溢出，结果必定大于C
            printf("Case #%d: true\n", i + 1);
        }
        else if (a < 0 && b < 0 && sum >= 0)
        { //负溢出，两个负数相加而且溢出，必小于C
            printf("Case #%d: false\n", i + 1);
        }
        else if (sum > c) //无溢出，正常比较
        {
            printf("Case #%d: true\n", i + 1);
        }
        else
        {
            printf("Case #%d: false\n", i + 1);
        }
    }
    system("pause");
    return 0;
}