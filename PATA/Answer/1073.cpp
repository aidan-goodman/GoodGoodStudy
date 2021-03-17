#include <iostream>
using namespace std;

int main()
{
    string str;
    cin >> str;
    int index = 0;
    while (str[index] != 'E')
    {
        index++;
    }
    string f_str = str.substr(1, index - 1); //从'E'进行分割，将指数前的字符去掉符号放到字符子串中
    int e = stoi(str.substr(index + 1));     //正负号也会进行判断
    if (str[0] == '-')                       //如果是一个负数，直接输出符号
    {
        cout << '-';
    }
    if (e < 0) //如果指数是负数，说明结果是一个小数
    {
        cout << "0.";
        for (int i = 0; i < abs(e) - 1; i++)
        {
            cout << '0';
        }
        for (int j = 0; j < f_str.length(); j++)
        {
            if (f_str[j] != '.')
            {
                cout << f_str[j];
            }
        }
    }
    else //如果是正数
    {
        cout << f_str[0]; //先输出小数点之前的一位
        int j, cnt;
        for (j = 2, cnt = 0; j < f_str.length() && cnt < e; j++, cnt++)
        { //略过小数点输出，同时判断长度并构造一个计数不超过指数
            cout << f_str[j];
        }
        if (j == f_str.length()) //如果字符串全部输出，说明未到指数，后面补零
        {
            for (int k = 0; k < e - cnt; k++)
            {
                cout << '0';
            }
        }
        else //指数到了指数未到，输出一个小数点继续输出
        {
            cout << '.';
            for (j; j < f_str.length(); j++)
            {
                cout << f_str[j];
            }
        }
    }
    system("pause");
    return 0;
}