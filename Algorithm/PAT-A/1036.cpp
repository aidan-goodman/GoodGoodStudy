#include <iostream>
using namespace std;

int main()
{
    int n, M_min = 101, F_max = -1; //设置人数变量，同时根据范围确定最大最小值
    string M, F;                    //男女生输出的姓名和编号可以用一个字符串搞定
    cin >> n;
    for (int i = 0; i < n; i++) //根据人数构建循环处理每行数据
    {
        string name_temp, Id_temp; //临时字符串保存姓名和编号
        char gender;
        int grade;
        cin >> name_temp >> gender >> Id_temp >> grade;
        if (gender == 'M' && grade < M_min) //男生且成绩小于男生成绩的最小值
        {
            M_min = grade;                 //成绩覆盖
            M = name_temp + " " + Id_temp; //保存姓名和编号
        }
        if (gender == 'F' && grade > F_max) //女生且成绩大于女生成绩的最大值
        {
            F_max = grade;
            F = name_temp + " " + Id_temp;
        }
    }
    if (F_max != -1) //如果成绩被改动说明有符合条件的人可以输出
    {
        cout << F << endl;
    }
    else
    {
        cout << "Absent\n";
    }
    if (M_min != 101)
    {
        cout << M << endl;
    }
    else
    {
        cout << "Absent\n";
    }
    if (M_min != 101 && F_max != -1) //如果男女生的成绩都有符合条件的人
    {
        cout << abs(M_min - F_max); //用绝对值输出，防止大小颠倒
    }
    else
    {
        cout << "NA";
    }
    system("pause");
    return 0;
}