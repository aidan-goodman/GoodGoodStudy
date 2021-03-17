#include <iostream>
#include <set>
using namespace std;

int n, m;
set<int> st[51];

void compare(int a, int b) //将比较方法独立出来
{
    int samenum = 0, totalnum = st[b].size();
    for (auto it = st[a].begin(); it != st[a].end(); it++)
    {
        if (st[b].find(*it) != st[b].end())
        {
            samenum++;
        }
        else
        {
            totalnum++;
        }
    }
    printf("%.1f%\n", samenum * 100.00 / totalnum); //输出保留一位小数
}

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        int size, temp;
        cin >> size;
        for (int j = 0; j < size; j++)
        {
            cin >> temp;
            st[i].insert(temp); //存储到set数组中
        }
    }
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        compare(a, b); //通过查找编号调用方法
    }
    return 0;
}