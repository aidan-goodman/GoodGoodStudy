#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    map<string, vector<int>> list;//建立集合，用姓名映射课程的方式
    char name[5];//直接输入字符串会超时，使用字符数组的方式
    for (int i = 0; i < k; i++)
    {
        int id, cnt;
        scanf("%d %d", &id, &cnt);
        for (int j = 0; j < cnt; j++)
        {
            scanf("%s", name);
            list[name].push_back(id);//根据姓名将课程ID放入
        }
    }
    for (int i = 0; i < n; i++)
    {
        scanf("%s", name);
        vector<int> v = list[name];//查询时放入临时数组
        printf("%s %d", name, v.size());
        sort(v.begin(), v.end());//排序后输出
        for (int j = 0; j < v.size(); j++)
        {
            printf(" %d", v[j]);
        }
        printf("\n");
    }
    system("pause");
    return 0;
}