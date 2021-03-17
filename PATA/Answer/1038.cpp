#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(string a, string b)
{
    return a + b < b + a; //如果a+b<b+a，a就在前面，否则反之
}

int main()
{
    int n;
    cin >> n;
    string str[n];
    for (int i = 0; i < n; i++)
    {
        cin >> str[i];
    }
    sort(str, str + n, cmp);
    string ans;
    for (int i = 0; i < n; i++)
    {
        ans += str[i]; //拼接排序后的字符数组
    }
    while (ans.length() != 0 && ans[0] == '0') //去掉前导零
    {
        ans.erase(ans.begin());
    }
    if (ans.length() == 0)
    {
        cout << 0;
    }
    else
    {
        cout << ans;
    }

    system("pause");
    return 0;
}