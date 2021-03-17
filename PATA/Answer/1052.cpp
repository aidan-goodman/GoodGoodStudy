#include <iostream>
#include <algorithm>
using namespace std;

const int edge = 100001;
struct Node
{
    int address, data, next;
    bool flag; //存在无法连接的节点，创建标记属性
};
bool cmp(Node a, Node b) //根据数据大小进行排序
{
    if (a.flag == false || b.flag == false) //只要a或b有一个不符合条件，就将其放置到最后
    {
        return a.flag > b.flag;
    }
    else
    {
        return a.data < b.data; //其他根据数据大小进行排序
    }
}

int main()
{
    Node node[edge];
    for (int i = 0; i < edge; i++)
    {
        node[i].flag = false; //先将所有节点的标记置为false
    }
    int N, begin;
    cin >> N >> begin;
    int address;
    for (int i = 0; i < N; i++)
    {
        cin >> address;
        cin >> node[address].data >> node[address].next;
        node[address].address = address;
    }
    int count = 0;
    while (begin != -1)
    {
        node[begin].flag = true; //将能够连接的节点标记为true
        count++;                 //记录有效节点的个数
        begin = node[begin].next;
    }
    if (count == 0) //没有有效节点直接进行输出
    {
        cout << "0 -1";
    }
    else
    {
        sort(node, node + edge, cmp);                //进行排序
        printf("%d %05d\n", count, node[0].address); //输出有效节点的个数和起始位置
        for (int i = 0; i < count; i++)
        {
            if (i < count - 1)
            {
                printf("%05d %d %05d\n", node[i].address, node[i].data, node[i + 1].address);
            }
            else
            {
                printf("%05d %d -1\n", node[i].address, node[i].data);
            }
        }
    }
    return 0;
}