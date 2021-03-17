#include <iostream>
using namespace std;

int main()
{
    string a;
    cin >> a;
    int sum = 0;
    for (int i = 0; i < a.length(); i++)
    {
        sum += a[i] - '0';//将每一位相加（不-0计算的是数字存储的ASCII码）
    }
    string s = to_string(sum);
    string digit[10] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    //将每个数字的读法放到数组中
    cout << digit[s[0] - '0'];
    for (int i = 1; i < s.length(); i++)
    {
        cout << " " << digit[s[i] - '0'];
    }
    system("pause");
    return 0;
}