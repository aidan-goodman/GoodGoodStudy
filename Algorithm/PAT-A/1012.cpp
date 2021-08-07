#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

struct Student //学生结构体
{
    string Id;
    int grades[4], ranks[4];           //对应的成绩和排名
} stu[2000];                           //不会超过2000人
char course[5] = {'A', 'C', 'M', 'E'}; //对应的课程，方便输出（这里的构造顺序要和处理时的顺序必须一致，顺序用题目给出的优先级即可）
int now, r;                            //表示课程和排名的处理
bool cmp(Student a, Student b)
{
    return a.grades[now] > b.grades[now];
}

int main()
{
    int n, m;
    cin >> n >> m;
    unordered_map<string, int> Map; //用于存储ID对应的下标，方便查询
    for (int i = 0; i < n; i++)
    {
        cin >> stu[i].Id >> stu[i].grades[1] >> stu[i].grades[2] >> stu[i].grades[3];
        stu[i].grades[0] = (stu[i].grades[1] + stu[i].grades[2] + stu[i].grades[3]) / 3 + 0.5; //平均值四舍五入
    }

    for (now = 0; now < 4; now++) //按每科成绩进行排序
    {
        sort(stu, stu + n, cmp);
        for (int i = 0; i < n; i++)
        {
            if (stu[i].grades[now] != stu[i - 1].grades[now] || i == 0)
            {
                r = i + 1; //处理排名并列的情况
            }
            stu[i].ranks[now] = r;
        }
    }

    for (int i = 0; i < n; i++)
    {
        Map[stu[i].Id] = i; //数据处理完成后将ID和下标对应存储，方便查询
    }

    while (m--)
    {
        string query;
        cin >> query;
        if (!Map.count(query)) //没查询到元素
        {
            cout << "N/A\n";
        }
        else
        {
            int index = Map[query], minRank = 2001, cour; //查询到了，获取其下标
            for (int i = 0; i < 4; i++)
            {
                if (stu[index].ranks[i] < minRank)
                {
                    minRank = stu[index].ranks[i]; //寻找这个学生的最小排名
                    cour = i;                      //获取最小排名的课程下标
                }
            }
            cout << minRank << " " << course[cour] << endl;
        }
    }
    system("pause");
    return 0;
}