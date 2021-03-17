#include <iostream>
using namespace std;

int main()
{
    int a, b;
    cin >> a >> b;
    string str = to_string(a + b);
    int len = str.length();
    for (int i = 0; i < len; i++)
    {
        cout << str[i];
        if (str[i] == '-')
        {
            continue;
        }
        if ((i + 1) % 3 == len % 3 && i + 1 != len)
        {
            cout << ',';
        }
    }
    system("pause");
    return 0;
}