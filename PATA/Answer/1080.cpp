#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct School
{
    int quota, last;   //last为录取的最后一个学生用来判断同排名
    vector<int> admit; //被录取的学生放到该数组
} school[100];

struct Applicant
{
    int Id, rnk, Ge, Gi, G; //学生ID要单独保存
    int choice[5];
} alct[40000];

int N, M, K;
bool cmp(Applicant a, Applicant b)
{
    if (a.G != b.G)
    {
        return a.G > b.G;
    }
    return a.Ge > b.Ge;
}

int main()
{
    cin >> N >> M >> K;
    for (int i = 0; i < M; i++)
    {
        cin >> school[i].quota; //输入每个学校的招生人数
    }
    for (int i = 0; i < N; i++)
    {
        cin >> alct[i].Ge >> alct[i].Gi;
        for (int j = 0; j < K; j++)
        {
            cin >> alct[i].choice[j];
        }
        alct[i].G = alct[i].Ge + alct[i].Gi; //相加即可
        alct[i].Id = i;                      //将编号保存，排序后仍使用原始编号
    }
    sort(alct, alct + N, cmp); //将学生按成绩排名
    for (int i = 0; i < N; i++)
    {
        if (i == 0 || alct[i].G != alct[i - 1].G || alct[i].Ge != alct[i - 1].Ge)
        { //分配名次
            alct[i].rnk = i + 1;
        }
        else
        {
            alct[i].rnk = alct[i - 1].rnk;
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < K; j++)
        {
            int k = alct[i].choice[j]; //遍历所有志愿
            if (school[k].admit.size() < school[k].quota || alct[i].rnk == alct[school[k].last].rnk)
            {                                          //人数没招满或与招到最后一人的排名相等
                school[k].admit.push_back(alct[i].Id); //ID放入数组
                school[k].last = i;                    //覆盖最后值
                break;
            }
        }
    }
    for (int i = 0; i < M; i++)
    {
        sort(school[i].admit.begin(), school[i].admit.end()); //对每个学校照到的学生按序号排序
        for (int j = 0; j < school[i].admit.size(); j++)
        {
            if (j)
            { //不是第一个就输出空格
                cout << " ";
            }
            cout << school[i].admit[j];
        }
        cout << endl;
    }

    system("pause");
    return 0;
}