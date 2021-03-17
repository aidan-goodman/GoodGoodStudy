#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(char a, char b)
{
    return a > b; //递减排序
}
int main()
{
    string str;
    cin >> str;
    str.insert(0, 4 - str.length(), '0');//不足4位前面补0
    do
    {
        string a = str, b = str;
        sort(a.begin(), a.end(), cmp);//降序排序
        sort(b.begin(), b.end());//升序排序
        int result = stoi(a) - stoi(b);//转换求值
        str = to_string(result);//再转为字符串
        str.insert(0, 4 - str.length(), '0');//补零
        cout << a << " - " << b << " = " << str << endl;

    } while (str != "6174" && str != "0000");
    syste("pause");
    return 0;
}