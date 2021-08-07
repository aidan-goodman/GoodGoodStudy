#include <iostream>
#include <cmath>
using namespace std;

long int num, temp;
int main()
{
    cin >> num;
    int first = 0, len = 0, maxn = sqrt(num) + 1; //乘积因子的最大值为n的开根
    for (int i = 2; i <= maxn; i++)               //控制起始因子
    {
        int j;
        temp = 1;
        for (j = i; j <= maxn; j++) //控制连续因子
        {
            temp *= j;
            if (num % temp != 0) //不再符合跳出
            {
                break;
            }
        }
        if (j - i > len) //每次更新最长长度
        {
            len = j - i;
            first = i;
        }
    }

    if (first == 0)
    {
        cout << 1 << endl
             << num;
    }
    else
    {
        cout << len << endl;
        for (int i = 0; i < len; i++)
        {
            cout << first + i;
            if (i != len - 1)
            {
                cout << '*';
            }
        }
    }
    system("pause");
    return 0;
}