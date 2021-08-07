#include <iostream>
#include <cctype>
#include <cmath>
#include <algorithm>
using namespace std;

long long convert(string str, long long radix)
{ //将已经确定进制的数转换为十进制
    int decimal = 0;
    int temp = 0, index = 0;
    for (auto it = str.rbegin(); it != str.rend(); it++)
    {
        temp = isdigit(*it) ? *it - '0' : *it - 'a' + 10;
        decimal += temp * pow(radix, index++);
    }
    return decimal;
}

long long findresult(string str, long long decimal)
{
    char it = *max_element(str.begin(), str.end());//使用函数求出ASCII码最大的字符
    long long low = (isdigit(it) ? it - '0' : it - 'a' + 10) + 1;//确定下界
    long long height = max(low, decimal);//确定上界
    while (low <= height)//二分判断
    {
        long long mid = low + (height - low) / 2;
        long long temp = convert(str, mid);
        if (temp < 0 || temp > decimal) //t小于0表示溢出
        {
            height = mid - 1;
        }
        else if (temp == decimal)
        {
            return mid;//相等返回mid作为指数
        }
        else
        {
            low = mid + 1;
        }
    }
    return -1;//不存在返回-1
}
int main()
{
    string s1, s2;
    long long tag = 0, radix = 0, result_radix;
    cin >> s1 >> s2 >> tag >> radix;
    if (s1 == s2)//如果输入直接相等，输出给定的指数
    {
        cout << radix;
    }
    else
    {
        result_radix = (tag == 1) ? findresult(s2, convert(s1, radix)) : findresult(s1, convert(s2, radix));
        if (result_radix == -1)
        {
            cout << "Impossible";
        }
        else
        {
            cout << result_radix;
        }
    }

    system("pause");
    return 0;
}