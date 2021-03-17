#include <iostream>
#include <cctype>
#include <vector>
using namespace std;

int main()
{
    /*字符串写法
    string s1, s2, ans;
    cin >> s1 >> s2;
    for (int i = 0; i < s1.length(); i++) //遍历字符串1中的每个字符去字符串2中查找
        if (s2.find(s1[i]) == string::npos && ans.find(toupper(s1[i])) == string::npos)
        { //查找字符和字符的大写，查找失败返回string::npos
            ans += toupper(s1[i]);
        }
    cout << ans;
    */
    int flag[128] = {0};
    vector<char> vc;
    string s1, s2;
    cin >> s1 >> s2;
    int i = 0, j = 0;
    while (i < s1.length()) //遍历全部的预想结果
    {
        if (s1[i] != s2[j])
        {
            if (!flag[s1[i]]) //还没有标记过
            {
                flag[tolower(s1[i])] = 1;
                flag[toupper(s1[i])] = 1;     //将大小写全部标记成1
                vc.push_back(toupper(s1[i])); //放入大写形式
            }
            i++;
        }
        else
        {
            i++;
            j++;
        }
    }
    for (char i : vc)
    {
        cout << i;
    }

    system("pause");
    return 0;
}