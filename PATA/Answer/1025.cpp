#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Student
{
    string num;
    int score, ranks[2], room; //ranks[0]代表总排名，1代表考场排名
};
bool cmp(Student a, Student b) //排序规则
{
    return a.score == b.score ? a.num < b.num : a.score > b.score;
}
int r; //处理并列排名

int main()
{
    int n, m;
    cin >> n;
    vector<Student> stu; //所有成员的结构体动态数组
    for (int i = 0; i < n; i++)
    {
        cin >> m;
        getchar(); //捕捉换行符
        Student temp_stu[m];
        for (int j = 0; j < m; j++)
        {
            cin >> temp_stu[j].num >> temp_stu[j].score;
            temp_stu[j].room = i + 1; //考场号就等于组数+1
        }
        sort(temp_stu, temp_stu + m, cmp); //对一个考场的所有成员进行排序
        for (int k = 0; k < m; k++)
        {
            if (k == 0 || temp_stu[k].score != temp_stu[k - 1].score)
            {
                r = k + 1;
            }
            temp_stu[k].ranks[1] = r;   //赋值考场排名
            stu.push_back(temp_stu[k]); //放入总数组
        }
    }
    sort(stu.begin(), stu.end(), cmp); //公共排名处理
    for (int i = 0; i < stu.size(); i++)
    {
        if (i == 0 || stu[i].score != stu[i - 1].score)
        {
            r = i + 1;
        }
        stu[i].ranks[0] = r;
    }
    cout << stu.size() << endl;
    for (int i = 0; i < stu.size(); i++)
    {
        cout << stu[i].num << " " << stu[i].ranks[0] << " " << stu[i].room << " " << stu[i].ranks[1] << endl;
    }
    system("pause");
    return 0;
}