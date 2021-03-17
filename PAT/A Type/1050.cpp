#include <iostream>
using namespace std;

int flag[256] = {0};
int main()
{
    string str1, str2;
    getline(cin, str1);
    getline(cin, str2);
    for (int i = 0; i < str1.length(); i++)
    {
        flag[str1[i]] = 1;
    }
    for (int i = 0; i < str2.length(); i++)
    {
        flag[str2[i]] = 0;
    }
    for (int i = 0; i < str1.length(); i++)
    {
        if (flag[str1[i]])
        {
            cout << str1[i];
        }
    }
    system("pause");
    return 0;
}