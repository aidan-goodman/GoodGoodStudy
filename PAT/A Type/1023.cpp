#include <iostream>
#include <vector>
#include <cstring>
using namespace std;

struct bignum//大数机构体
{
    int num[25], len;
    bignum()//初始化构造方法
    {
        memset(num, 0, sizeof(num));
        len = 0;
    }
};

bignum add(bignum a, bignum b)//大数相加方法
{
    bignum c;
    int carry = 0;
    for (int i = 0; i < a.len || i < b.len; i++)
    {
        int temp = a.num[i] + b.num[i] + carry;
        c.num[c.len++] = temp % 10;
        carry = temp / 10;
    }
    if (carry != 0)
    {
        c.num[c.len++] = carry;
    }
    return c;
}

bignum multi(bignum a, int b)//大数乘int型方法
{
    bignum c;
    int carry = 0;
    for (int i = 0; i < a.len; i++)
    {
        int temp = a.num[i] * b + carry;
        c.num[c.len++] = temp % 10;
        carry = temp / 10;
    }
    while (carry != 0)
    {
        c.num[c.len++] = carry % 10;
        carry /= 10;
    }
    return c;
}

int main()
{
    string str;
    cin >> str;
    vector<int> flag(10, 0);
    bool p = true;
    bignum bign;
    bign.len = str.length();
    for (int i = 0; i < str.length(); i++)
    {
        bign.num[i] = str[bign.len - i - 1] - '0';
        flag[bign.num[i]]++;//标记每一个数字的出现次数
    }
    bignum result = multi(bign, 2);//将其乘2
    for (int i = 0; i < result.len; i++)
    {
        flag[result.num[i]]--;
    }
    if (bign.len != result.len)
    {
        p = false;
    }
    else
    {
        for (int i = 1; i <= 9; i++)
        {
            if (flag[i])
            {
                p = false;
            }
        }
    }

    if (p)
    {
        cout << "Yes" << endl;
    }
    else
    {
        cout << "No" << endl;
    }
    for (int i = result.len - 1; i >= 0; i--)
    {
        cout << result.num[i];
    }
    system("pause");
    return 0;
}