#include <iostream>
using namespace std;

int main()
{
    string num[10] = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"}; //数字单词
    string wei[5] = {"Shi", "Bai", "Qian", "Wan", "Yi"};                                //位数单词
    string str;
    cin >> str;                             //输入字符串
    int left = 0, right = str.length() - 1; //设置左右下标，四位一组输出
    if (str[0] == '-')
    {
        cout << "Fu"; //符号单独处理
        left++;       //从下标1开始
    }
    while (left + 4 <= right)
    {
        right -= 4; //始终让left和right在同一节
    }
    while (left < str.length()) //没全部读出就始终循环
    {
        bool zero = false;
        bool isPrint = false;
        while (left <= right) //单节处理
        {
            if (left > 0 && str[left] == '0')
            { //标识零位
                zero = true;
            }
            else
            {
                if (zero) //先判断之前有无零位
                {
                    cout << " ling";
                    zero = false;
                }
                if (left > 0) //只要不是第一个数组就必须用空格分割
                {
                    cout << " ";
                }
                cout << num[str[left] - '0']; //输出数字
                isPrint = true;               //标志有输出，需要进行万或者亿的输出
                if (left != right)            //只要这一节没到最后一个字符就要输出千、百、十
                {
                    cout << " " << wei[right - left - 1];
                }
            }
            left++; //左下标后移
        }
        if (isPrint && right != str.length() - 1) //有输出而且不是最后一节
        {
            cout << " " << wei[(str.length() - right) / 4 + 2]; //输出万或者亿
        }
        right += 4; //右坐标移动到下一节
    }
    system("pause");
    return 0;
}