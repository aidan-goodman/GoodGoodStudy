#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Student
{
    int Id, virtue, talent, total;
    int rank; //表示类别，1~4
};

bool cmp(Student a, Student b)
{ //排序规则
    if (a.rank != b.rank)
    { //类别不同，按类别从小到大
        return a.rank < b.rank;
    }
    else if (a.total != b.total)
    {
        return a.total > b.total;
    }
    else if (a.virtue != b.virtue)
    {
        return a.virtue > b.virtue;
    }
    else
    { //全部相同，按学号
        return a.Id < b.Id;
    }
}

int main()
{
    int n, low, height;
    cin >> n >> low >> height;
    vector<Student> stu; //建立一个结构体的动态数组
    for (int i = 0; i < n; i++)
    {
        Student temp; //临时结构体变量
        cin >> temp.Id >> temp.virtue >> temp.talent;
        temp.total = temp.virtue + temp.talent; //对每一个数据都计算它的总成绩
        if (temp.virtue < low || temp.talent < low)
        {
            continue; //如果不符合条件直接处理下一个
        }
        else if (temp.virtue >= height && temp.talent >= height) //这里可以是等于
        {
            temp.rank = 1;
            stu.push_back(temp);
        }
        else if (temp.virtue >= height && temp.talent < height)
        {
            temp.rank = 2;
            stu.push_back(temp);
        }
        else if (temp.virtue < height && temp.talent < height && temp.virtue >= temp.talent) //不小于
        {
            temp.rank = 3;
            stu.push_back(temp);
        }
        else
        {
            temp.rank = 4;
            stu.push_back(temp);
        }
    }
    sort(stu.begin(), stu.end(), cmp); //根据规则排序
    cout << stu.size() << endl;        //输出符合条件的人数
    for (int i = 0; i < stu.size(); i++)
    { //按规则循环输出
        cout << stu[i].Id << " " << stu[i].virtue << " " << stu[i].talent << endl;
    }
    system("pause");
    return 0;
}