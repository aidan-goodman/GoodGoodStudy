#include <iostream>
#include <vector>
using namespace std;

vector<int> prime(50000, 1); //乘积因子不会大于50000，建立素数表，初始为1
long int num;
int main()
{
    for (int i = 2; i * i < 50000; i++)
    {
        for (int j = 2; j * i < 50000; j++)
        {
            prime[i * j] = 0; //将不是素数的标记为0
        }
    }
    cin >> num;
    cout << num << '=';
    if (num == 1)
    {
        cout << 1;
    }
    bool state = false; //有无因子输出标志
    for (int i = 2; i < 50000 && num >= 2; i++)
    {
        int cnt = 0;                          //指数
        bool flag = false;                    //条件符合
        while (prime[i] == 1 && num % i == 0) //是素数而且可以整除
        {
            num /= i;
            cnt++;
            flag = true;
        }
        if (flag)
        {
            if (state)
            {
                cout << '*';
            }
            cout << i;
            state = true;
        }
        if (cnt > 1)
        {
            cout << '^' << cnt;
        }
    }
    return 0;
}