#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;

int n, k, m; //总人数，问题数和提交记录的数量
struct Record
{
    int rank, Id, passnum = 0;              //passnum表示完美通过的数量
    int score[6] = {0, -2, -2, -2, -2, -2}; //-2==没有提交过；-1==没通过编译
    bool isShow = false;                    //若没有一条能够通过编译不显示
};

bool cmp(Record a, Record b)
{
    if (a.score[0] != b.score[0])
    {
        return a.score[0] >= b.score[0];
    }
    else if (a.passnum != b.passnum)
    {
        return a.passnum >= b.passnum;
    }
    else
    {
        return a.Id < b.Id;
    }
}

int main()
{
    scanf("%d %d %d", &n, &k, &m);
    vector<Record> v(n + 1);     //输入记录的时候遍历寻找是哪个人进行提交是不现实的，直接用ID作为下标
    int full_score[k];           //保存每道题目的成绩上限
    for (int i = 1; i <= k; i++) //题号从1开始
    {
        scanf("%d", &full_score[i]); //输入每一题的满分
    }
    int Id, pro_num, score_obt;
    for (int i = 0; i < m; i++)
    {
        scanf("%d %d %d", &Id, &pro_num, &score_obt);
        v[Id].Id = Id;
        v[Id].score[pro_num] = max(v[Id].score[pro_num], score_obt); //多次提交保留最大值
        if (score_obt != -1)                                         //只要有成绩就置为可以输出
        {
            v[Id].isShow = true;
        }
    } //输入处理完成

    for (int i = 1; i <= n; i++) //学生的序号一直到n
    {
        for (int j = 1; j <= k; j++) //题目的序号一直到k
        {
            if (v[i].score[j] != -2 && v[i].score[j] != -1)
            {
                v[i].score[0] += v[i].score[j]; //相加有效成绩
            }
            if (v[i].score[j] == full_score[j])
            {
                v[i].passnum++; //记录满分数量
            }
        }
    }
    sort(v.begin() + 1, v.end(), cmp); //0恒为空值
    for (int i = 1; i <= n; i++)       //赋予排名
    {
        v[i].rank = i;
        if (i != 1 && v[i].score[0] == v[i - 1].score[0])
        {
            v[i].rank = v[i - 1].rank;
        }
    } //处理完成

    for (int i = 1; i <= n; i++)
    {
        if (v[i].isShow) //判断有无输出条件按格式输出
        {
            printf("%d %05d %d", v[i].rank, v[i].Id, v[i].score[0]);
            for (int j = 1; j <= k; j++)
            {
                if (v[i].score[j] != -1 && v[i].score[j] != -2)
                    printf(" %d", v[i].score[j]);
                else if (v[i].score[j] == -2)
                    printf(" -");
                else
                    printf(" 0");
            }
            printf("\n");
        }
    }
    system("pause");
    return 0;
}