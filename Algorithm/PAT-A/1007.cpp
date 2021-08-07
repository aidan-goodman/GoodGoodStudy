#include <iostream>
using namespace std;

const int maxn = 10010;
int data[maxn], dp[maxn]; //存储数据和子串和
int beg[maxn] = {0};      //记录当前以i为结尾的子串的起始下标

int main()
{
    int n;
    cin >> n;
    bool flag = false;
    for (int i = 0; i < n; i++)
    {
        cin >> data[i];
        if (data[i] >= 0)
        {
            flag = true; //只要有一个正数就可以进行运算
        }
    }
    if (!flag) //如果全是负数
    {
        cout << "0 " << data[0] << " " << data[n - 1];
        return 0;
    }
    dp[0] = data[0];
    for (int i = 1; i < n; i++) //状态转移方程
    {
        if (dp[i - 1] + data[i] > data[i])
        {
            dp[i] = dp[i - 1] + data[i];
            beg[i] = beg[i - 1];
        }
        else
        {
            dp[i] = data[i];
            beg[i] = i;
        }
    }
    int end = 0; //结束节点
    for (int i = 0; i < n; i++)
    {
        if (dp[i] > dp[end])
        {
            end = i;
        }
    }
    cout << dp[end] << " " << data[beg[end]] << " " << data[end];
    return 0;
}