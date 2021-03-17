#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n, p;
    cin >> n >> p;
    int arr[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n); //从小到大排序
    int ans = 1;
    for (int i = 0; i < n; i++)
    { //从数组的开始每次找一个数作为m进行判断
        int bound = upper_bound(arr, arr + n, (long long)arr[i] * p) - arr;
        //arr[i]作为m时符合完美队列条件的长度
        ans = max(ans, bound - i); //保留最大长度
    }
    cout << ans;
    system("pause");
    return 0;
}