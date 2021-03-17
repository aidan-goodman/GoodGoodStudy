#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    double ans = 0, temp;
    for (int i = 1; i <= n; i++)
    {
        cin >> temp;
        ans += temp * i * (n + 1 - i);
    }
    printf("%.2f", ans);
    system("pause");
    return 0;
}