#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, coins[10010];
int dp[10010], choice[10010][110];
bool cmp(int a, int b)
{
    return a > b;
}

int main()
{
    cin >> N >> M;
    for (int i = 1; i <= N; i++)
    {
        cin >> coins[i];
    }
    sort(coins + 1, coins + N + 1, cmp); //将硬币从大到小排序
    //背包模板
    for (int i = 1; i <= N; i++)
    {
        for (int j = M; j >= coins[i]; j--)
        {
            if (dp[j] <= dp[j - coins[i]] + coins[i])
            {
                choice[i][j] = true;
                dp[j] = dp[j - coins[i]] + coins[i];
            }
        }
    }

    if (dp[M] != M)
    {
        cout << "No Solution";
    }
    else
    {
        vector<int> arr;
        int v = M, index = N;
        while (v > 0) //反向查找，保证字典序最小
        {
            if (choice[index][v])
            {
                arr.push_back(coins[index]);
                v -= coins[index];
            }
            index--;
        }
        
        for (int i = 0; i < arr.size(); i++)
        {
            if (i != 0)
            {
                cout << " ";
            }
            cout << arr[i];
        }
    }
    system("pause");
    return 0;
}