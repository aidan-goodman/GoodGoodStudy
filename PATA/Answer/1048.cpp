#include <iostream>
using namespace std;

int flag[1001] = {0}; //用来统计每个面值出现了几次
int main()
{
    int n, m, temp;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        flag[temp]++;
    }
    for (int i = 1; i < m; i++) //对每个面值的硬币从小到大判断（保证输出规则）
    {
        if (flag[i]) //当前面值存在
        {
            flag[i]--;       //存在就-1，防止出现一个数出现了一次但它的二倍等于bill
            if (flag[m - i]) //符合相加条件的硬币也存在
            {
                cout << i << " " << m - i; //输出
                system("pause");
                return 0;
            }
            flag[i]++;
        }
    }
    cout << "No Solution";
    system("pause");
    return 0;
}