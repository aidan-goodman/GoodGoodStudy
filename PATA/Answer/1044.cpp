#include <iostream>
#include <vector>
using namespace std;

int n, m;
vector<int> sum, resultArr;
void Func(int i, int &j, int &tempsum) //二分就目标值
{
    int left = i, right = n;
    while (left < right)
    {
        int mid = left + (right - left) / 2;
        if (sum[mid] - sum[i - 1] >= m) //不一定完全匹配，求较大的最小值
        {
            right = mid;
        }
        else
        {
            left = mid + 1;
        }
    }
    j = right;
    tempsum = sum[j] - sum[i - 1];
}
int main()
{
    cin >> n >> m;
    sum.resize(n + 1);
    sum[0] = 0;
    for (int i = 1; i <= n; i++)
    {
        cin >> sum[i];
        sum[i] += sum[i - 1];
    }
    int minans = sum[n];
    for (int i = 1; i <= n; i++) //遍历所有数字作为左端点
    {
        int j, tempsum;
        Func(i, j, tempsum);  //挨个二分查找
        if (tempsum > minans) //如果过大下一次循环
        {
            continue;
        }
        if (tempsum >= m) //符合条件
        {
            if (tempsum < minans) //有更接近目标值的数字便更新集合
            {
                resultArr.clear();
                minans = tempsum;
            }
            resultArr.push_back(i);
            resultArr.push_back(j);
        }
    }
    for (int i = 0; i < resultArr.size(); i += 2)
    {
        cout << resultArr[i] << "-" << resultArr[i + 1] << endl;
    }

    system("pause");
    return 0;
}