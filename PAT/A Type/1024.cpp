#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

struct bign
{
    int num[1000], len;
    bign()
    {
        memset(num, 0, sizeof(num));
        len = 0;
    }
};

bign change(string str)
{
    bign temp;
    temp.len = str.length();
    for (int i = 0; i < str.length(); i++)
    {
        temp.num[i] = str[temp.len - i - 1] - '0';
    }
    return temp;
}

bign add(bign a, bign b)
{
    bign c;
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

bool judge(bign a)
{
    for (int i = 0; i < a.len / 2; i++)
    {
        if (a.num[i] != a.num[a.len - 1 - i])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    string str;
    int n;
    cin >> str >> n;
    bign a = change(str);
    int k = 0;
    while (k < n && judge(a) == false)
    {
        bign b = a;
        reverse(b.num, b.num + b.len);
        a = add(a, b);
        k++;
    }
    for (int i = a.len - 1; i >= 0; i--)
    {
        cout << a.num[i];
    }
    cout << endl
         << k;
    system("pause");
    return 0;
}