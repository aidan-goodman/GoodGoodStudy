#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    getchar(); //截获\n，不然下面读取字符串时第一个读取的是换行符
    string ans;
    for (int i = 0; i < n; i++)
    {
        string s;
        getline(cin, s);
        reverse(s.begin(), s.end()); //反转后方便判断
        if (i == 0)
        {
            ans = s;
            continue;
        }
        else
        {
            if (s.length() < ans.length()) //判断最短的
            {
                swap(ans, s);
            }
            int minlen = min(s.length(), ans.length());
            for (int j = 0; j < minlen; j++)
            {
                if (ans[j] != s[j])
                {
                    ans = ans.substr(0, j); //将公共子串截取出来
                    break;
                }
            }
        }
    }
    reverse(ans.begin(), ans.end()); //再翻转回初始状态
    if (ans.length() == 0)
    {
        ans = "nai";
    }
    cout << ans;
    system("pause");
    return 0;
}