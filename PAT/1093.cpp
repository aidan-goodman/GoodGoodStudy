#include <iostream>
using namespace std;

const int mod = 1000000007;
int main()
{
    string str;
    cin >> str;
    int len = str.length();
    int countP[100000] = {0};

    for (int i = 0; i < len; i++) //获取每个位置左侧字符'P'的个数
    {
        if (i > 0)
        {
            countP[i] = countP[i - 1];
        }
        if (str[i] == 'P')
        {
            countP[i]++;
        }
    }

    int ans = 0, countT = 0;
    for (int i = len - 1; i >= 0; i--)
    {
        if (str[i] == 'T')
        {
            countT++; //累计T
        }
        if (str[i] == 'A') //遇到'A'便相加取模
        {
            ans = (ans + countT * countP[i]) % mod;
        }
    }
    cout << ans;
    system("pause");
    return 0;
}