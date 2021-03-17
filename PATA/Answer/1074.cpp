#include <iostream>
#include <algorithm>
using namespace std;

const int edge = 100010;
struct Node //定义链表的结点结构体
{
    int address, data, next;
    int order; //定义位置，后续排序
};

bool cmp(Node a, Node b) //排序规则
{
    return a.order < b.order;
}

int main()
{
    Node node[edge];
    for (int i = 0; i < edge; i++)
    {
        node[i].order = edge; //将所有的规则定义为一个较大值
    }

    int begin, n, k;
    cin >> begin >> n >> k;
    int address;
    for (int i = 0; i < n; i++) //读入数据
    {
        cin >> address;
        cin >> node[address].data >> node[address].next;
        node[address].address = address;
    }
    int count = 0;
    while (begin != -1)
    {
        node[begin].order = count++; //将规则的先后顺序定义
        begin = node[begin].next;
    }
    sort(node, node + edge, cmp);       //排序连接起来
    for (int i = 0; i < count / k; i++) //分块进行输出
    {
        for (int j = (i + 1) * k - 1; j > i * k; j--)
        {
            printf("%05d %d %05d\n", node[j].address, node[j].data, node[j - 1].address);
        }
        //每一组的最后一个数据进行判断输出
        printf("%05d %d ", node[i * k].address, node[i * k].data); //输出数据
        if (i < count / k - 1)                                     //如果不是最后一组
        {
            printf("%05d\n", node[(i + 2) * k - 1].address); //输出越组后的最后一个（倒序的第一个）
        }
        else
        {
            if (count % k == 0) //如果能整分组，输出-1
            {
                printf("-1\n");
            }
            else //不能整分
            {
                printf("%05d\n", node[(i + 1) * k].address); //不能分组的第一个的地址
                for (int l = count / k * k; l < count; l++)  //将其照常输出即可
                {
                    printf("%05d %d ", node[l].address, node[l].data);
                    if (l < count - 1)
                    {
                        printf("%05d\n", node[l + 1].address);
                    }
                    else
                    {
                        printf("-1\n");
                    }
                }
            }
        }
    }
    system("pause");
    return 0;
}