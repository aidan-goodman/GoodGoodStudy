#include <iostream>
#include <map>
#include <cctype>
using namespace std;

int main()
{
    string str, temp;
    map<string, int> mcount;
    getline(cin, str);
    for (int i = 0; i < str.length(); i++)
    {
        if (isalnum(str[i])) //属于数字和字母
        {
            if (isupper(str[i]))
            { //大写转换为小写
                str[i] = tolower(str[i]);
            }
            temp += str[i];
        }
        if (!isalnum(str[i]) || i == str.length() - 1) //非法字符或最后一位
        {
            if (temp.length() != 0)
            {
                mcount[temp]++; //不为空便自增
            }
            temp.clear();
        }
    }
    int max = 0;
    string ans;
    for (auto it = mcount.begin(); it != mcount.end(); it++)
    {
        if (it->second > max)
        {
            max = it->second;
            ans = it->first; //遍历求次数最大，记录输出
        }
    }
    cout << ans << " " << max << endl;
    return 0;
}