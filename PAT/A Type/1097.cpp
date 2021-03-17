#include <cstdio>
#include <stdlib.h>
#include <algorithm>
using namespace std;

const int maxn = 100000;
struct NODE
{
    int address, key, next, num = 2 * maxn; //num让其数时数据规模的两倍，中间留出充足的空间进行分类放置
} node[maxn];
bool exist[maxn] = {false};
int cmp(NODE a, NODE b)
{
    return a.num < b.num;
}
int main()
{
    int begin, n, cnt1 = 0, cnt2 = 0, a; //cnt1表示有效的，cnt2表示被删除的
    scanf("%d%d", &begin, &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a);
        scanf("%d%d", &node[a].key, &node[a].next);
        node[a].address = a;
    }
    for (int i = begin; i != -1; i = node[i].next) //遍历
    {
        if (exist[abs(node[i].key)] == false) //如果这个数的绝对值没有出现过
        {
            exist[abs(node[i].key)] = true; //表示出现
            node[i].num = cnt1++;           //为其赋予第几个有效位
        }
        else
        {
            node[i].num = maxn + cnt2++; //为其赋予第几个无效位
        }
    }
    sort(node, node + maxn, cmp);
    int cnt = cnt1 + cnt2;
    for (int i = 0; i < cnt; i++)
    {
        if (i != cnt1 - 1 && i != cnt - 1) //不是两类的最后一个节点
        {
            printf("%05d %d %05d\n", node[i].address, node[i].key, node[i + 1].address);
        }
        else
        {
            printf("%05d %d -1\n", node[i].address, node[i].key);
        }
    }
    return 0;
}