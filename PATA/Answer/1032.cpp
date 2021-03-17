#include <iostream>
using namespace std;

const int edge = 100001;
struct Node //定义结构体
{
    char data;
    int next;
    bool flag; //对第一条链表的出现的节点赋予正值
};

int main()
{
    Node node[edge];
    for (int i = 0; i < edge; i++)
    {
        node[i].flag = false; //将每一个节点初始设置为未出现
    }
    int begin1, begin2, total;
    cin >> begin1 >> begin2 >> total;
    int address, next;
    char data;
    for (int i = 0; i < total; i++)
    {
        cin >> address >> data >> next;
        node[address].data = data;
        node[address].next = next;
    }
    while (begin1 != -1) //遍历第一条，对每一个节点做标记
    {
        node[begin1].flag = true;
        begin1 = node[begin1].next;
    }
    while (begin2 != -1)
    {
        if (node[begin2].flag)
        {
            break; //在第二条中出现被标记的节点跳出
        }
        begin2 = node[begin2].next;
    }
    if (begin2 != -1)
    {
        printf("%05d", begin2);
    }
    else
    {
        printf("-1");
    }
    return 0;
}