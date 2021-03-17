#include <iostream>
using namespace std;
/*
将和值转换为字符串，通过下标判断逗号的输出

判断条件可以从右往左看，当三位时输出一个逗号，
也就是字符串的长度mod3的位置，在从左往右看，
下标i从0开始，如果 (i + 1) % 3 == len % 3 
成立就输出逗号，注意最后一位不输出
*/
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
        //第一位输出的可能是一个负号
        if ((i + 1) % 3 == len % 3 && i + 1 != len)
        {
            cout << ',';
        }
    }
    system("pause");
    return 0;
}
