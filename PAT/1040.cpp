#include <iostream>
using namespace std;

int main()
{
    string str;
    getline(cin, str);
    int maxlen = 0, j, k;
    for (int i = 0; i < str.size(); i++) //以字符做对称轴
    {
        for (j = i, k = i; j >= 0 && k < str.size() && str[j] == str[k]; j--, k++)
            ;
        if (k - j - 1 > maxlen)
        {
            maxlen = k - j - 1;
        }
    }
    for (int i = 0; i < str.size() - 1; i++) //字符中间做对称轴
    {
        for (j = i, k = i + 1; j >= 0 && k < str.size() && str[j] == str[k]; j--, k++)
            ;
        if (k - j - 1 > maxlen)
        {
            maxlen = k - j - 1;
        }
    }
    cout << maxlen;
    return 0;
}