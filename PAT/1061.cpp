#include <iostream>
#include <cctype>
using namespace std;

int main()
{
    string a, b, c, d;
    cin >> a >> b >> c >> d;                 //输入字符串
    char time[2];                            //记录星期和小时
    int i = 0, j = 0;                        //控制字符串遍历，减少循环次数
    int m;                                   //记录分钟
    while (i < a.length() && i < a.length()) //同时出现才算符合条件
    {
        if (a[i] == b[i] && (a[i] >= 'A' && a[i] <= 'G')) //星期字母不会超过G
        {
            time[0] = a[i];
            break; //保留字符，跳出循环
        }
        i++;
    }
    i++;
    while (i < a.length() && i < a.length())
    {
        if (a[i] == b[i] && ((a[i] >= 'A' && a[i] <= 'N') || isdigit(a[i]))) //数字或者N之前的字符
        {
            time[1] = a[i];
            break; //保留并跳出
        }
        i++;
    }
    while (j < c.length() && j < d.length())
    {
        if (c[j] == d[j] && isalpha(c[j])) //分钟必须时字母
        {
            m = j; //只需保存位置
            break;
        }
        j++;
    }
    string week[7] = {"MON ", "TUE ", "WED ", "THU ", "FRI ", "SAT ", "SUN "};
    printf("%s", week[time[0] - 'A'].c_str());                     //注意输出格式，转换为只读指针
    int h = isdigit(time[1]) ? time[1] - '0' : time[1] - 'A' + 10; //0也是字符型必须有单引号
    printf("%02d:%02d", h, m);                                     //输出两位不足补零
    system("pause");
    return 0;
}