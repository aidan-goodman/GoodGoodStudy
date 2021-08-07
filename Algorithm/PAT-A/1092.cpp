#include <iostream>
#include <unordered_map>
using namespace std;

int main()
{
    unordered_map<char, int> mci;
    string str1, str2;
    cin >> str1 >> str2;
    /*数组下标标记法
    int book[256];
    for (int i = 0; i < str1.length(); i++)
        book[str1[i]]++;
    int result = 0;
    for (int i = 0; i < str2.length(); i++)
    {
        if (book[str2[i]] > 0)
            book[str2[i]]--;
        else
            result++;
    }
    */
    //集合标记
    for (int i = 0; i < str1.length(); i++)
    {
        if (mci.count(str1[i]))
        {
            mci[str1[i]]++;
        }
        else
        {
            mci[str1[i]] = 1;
        }
    }
    int lack = 0;
    for (int i = 0; i < str2.length(); i++)
    {
        if (mci.count(str2[i]) && mci[str2[i]] != 0)
        {
            mci[str2[i]]--;
        }
        else
        {
            lack++;
        }
    }
    if (!lack)
    {
        cout << "Yes " << str1.length() - str2.length();
    }
    else
    {
        cout << "No " << lack;
    }

    system("pause");
    return 0;
}