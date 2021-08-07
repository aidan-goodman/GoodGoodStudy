#include <iostream>
#include <queue>
using namespace std;

struct Mouse //建立老鼠结构体
{
    int weight, rank;
};

int main()
{
    Mouse mouse[1001];
    int Np, Ng;
    cin >> Np >> Ng;
    for (int i = 0; i < Np; i++) //按输入顺序为其编号
    {
        cin >> mouse[i].weight;
    }
    queue<int> qu;
    int order;
    for (int i = 0; i < Np; i++)
    {
        cin >> order;
        qu.push(order); //将排列顺序放入队列中
    }
    int temp = Np, group;  //temp表示此轮的人员，group表示分成几组
    while (qu.size() != 1) //角逐到只剩一个
    {
        if (temp % Ng == 0)
        {
            group = temp / Ng;
        }
        else
        {
            group = temp / Ng + 1;
        }
        for (int i = 0; i < group; i++)
        {
            int k = qu.front(); //k表示小组的胜出者
            for (int j = 0; j < Ng; j++)
            {
                if (i * Ng + j >= temp) //存在最后一组数量不够的情况
                {
                    break;
                }
                int front = qu.front();
                if (mouse[front].weight > mouse[k].weight)
                {
                    k = front;
                }
                mouse[front].rank = group + 1; //每次都更新排名
                qu.pop();
            }
            qu.push(k); //每组最大的放到队列中进入下一轮
        }
        temp = group; //新一轮的成员数就是上一轮的组数
    }
    mouse[qu.front()].rank = 1;
    for (int i = 0; i < Np; i++)
    {
        cout << mouse[i].rank;
        if (i < Np - 1)
        {
            cout << " ";
        }
    }
    system("pause");
    return 0;
}