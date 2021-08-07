#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, m;
    cin >> n;
    vector<int> coupon(n);
    for (int i = 0; i < n; i++)
    {
        cin >> coupon[i];
    }
    cin >> m;
    vector<int> product(m);
    for (int i = 0; i < m; i++)
    {
        cin >> product[i];
    }
    sort(coupon.begin(), coupon.end());
    sort(product.begin(), product.end()); //将数组从小到大排序
    int i = 0, j = 0, ans = 0;
    while (i < n && j < m && coupon[i] < 0 && product[j] < 0) //处理负数
    {
        ans += coupon[i] * product[j];
        i++;
        j++;
    }
    i = n - 1;
    j = m - 1;
    while (i >= 0 && j >= 0 && coupon[i] > 0 && product[j] > 0) //处理正数
    {
        ans += coupon[i] * product[j];
        i--;
        j--;
    }
    cout << ans;
    system("pause");
    return 0;
}