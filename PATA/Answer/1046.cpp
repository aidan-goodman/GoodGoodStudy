#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n;
    scanf("%d", &n);
    vector<int> dis(n + 1); //动态数组分配空间后所有的值为0
    int sum = 0, left, right;
    for (int i = 1; i <= n; i++)
    {
        int temp;
        scanf("%d", &temp);
        sum += temp;
        dis[i] = sum; //距离数组保存的是V1到Vi的顺时针距离
    }
    int cnt;
    scanf("%d", &cnt); //输入判断几对
    for (int i = 0; i < cnt; i++)
    {
        scanf("%d %d", &left, &right);
        if (left > right) //始终保持顺时针判断
            swap(left, right);
        int temp = dis[right - 1] - dis[left - 1];
        printf("%d\n", min(temp, sum - temp));
    }
    system("pause");
    return 0;
}