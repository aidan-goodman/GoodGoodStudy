#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int N, K, P, maxsum = -1;      //定义一个底数和用来判断底数最大的序列
vector<int> factor, ans, temp; //factor用来保存所有不超过N的因子，下标为底数，数据为pow(index,P)
//ans存储答案，temp为DFS搜索过程中的临时序列存储
void init() //将所有小于N的因子存放到数组中
{
    int i = 0, temp = 0;
    while (temp <= N)
    {
        factor.push_back(temp);
        temp = (int)pow((double)++i, (double)P);
    }
}
void DFS(int index, int nowK, int sum, int facsum) //参数为下标，当前步，数据和与底数和
{
    if (sum == N && nowK == K) //当和与步数到达目标数值时判断
    {
        if (facsum > maxsum) //输出底数和最大的一个
        {
            ans = temp;
            maxsum = facsum;
        }
        return;
    }
    if (sum > N || nowK > K) //和或步数超过目标数值，表示不符合条件
    {
        return;
    }
    if (index - 1 >= 0) //factor[0]=0;只是为了数据存储的条理性，不必参与运算
    {
        temp.push_back(index); //将当前下标放入后进行下一步搜索
        DFS(index, nowK + 1, sum + factor[index], facsum + index);
        temp.pop_back(); //成功或失败后，回溯，在进行搜索
        DFS(index - 1, nowK, sum, facsum);
    }
}

int main()
{
    cin >> N >> K >> P;
    init();
    DFS(factor.size() - 1, 0, 0, 0);
    if (maxsum == -1) //只要不为-1说明有答案
    {
        cout << "Impossible";
    }
    else
    {
        cout << N << " = " << ans[0] << "^" << P;
        for (int i = 1; i < ans.size(); i++)
        {
            cout << " + " << ans[i] << "^" << P;
        }
    }
    system("pause");
    return 0;
}