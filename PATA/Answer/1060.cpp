#include <iostream>
#include <string>
using namespace std;

int n;
string deal(string str, int &e) //字符串处理方法，指数e为恒定地址变量
{
    int k = 0;
    while (str.length() > 0 && str[0] == '0') //将前导0去除
    {
        str.erase(str.begin());
    }
    if (str[0] == '.') //去掉0为小数点说明为小数
    {
        str.erase(str.begin());
        while (str.length() > 0 && str[0] == '0') //通过小数点后边0的个数获得指数的负数值
        {
            str.erase(str.begin());
            e--;
        }
    }
    else //不是小数点即为整数
    {
        while (k < str.length() && str[k] != '.') //小数点之前的位数为指数值
        {
            k++;
            e++;
        }
        if (k < str.length()) //最后k的值小于字符串长度说明有小数点，将其去掉
        {
            str.erase(str.begin() + k);
        }
    }
    if (str.length() == 0) //如果去掉0，字符串长度为0，说明指数也为0
    {
        e = 0;
    }
    int num = 0;
    k = 0;
    string dealed;
    while (num < n) //保存n个有效数字
    {
        if (k < str.length())
        {
            dealed += str[k++];
        }
        else
        {
            dealed += '0';
        }
        num++;
    }
    return dealed;
}

int main()
{
    string s1, s2, s3, s4;
    cin >> n >> s1 >> s2;
    int e1 = 0, e2 = 0;
    s3 = deal(s1, e1);
    s4 = deal(s2, e2);
    if (s3 == s4 && e1 == e2) //通过有效数字和指数判断科学计数法是否相同
    {
        cout << "YES 0." << s3 << "*10^" << e1;
    }
    else
    {
        cout << "NO 0." << s3 << "*10^" << e1 << " 0." << s4 << "*10^" << e2;
    }
    system("pause");
    return 0;
}