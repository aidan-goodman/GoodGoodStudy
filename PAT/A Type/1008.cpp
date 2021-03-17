#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int now = 0, ans = 0, temp;
    while (n--)
    {
        cin >> temp;
        if (temp >= now)
        {
            ans += 6 * (temp - now) + 5;
        }
        else if (temp < now)
        {
            ans += 4 * (now - temp) + 5;
        }
        now = temp;
    }
    cout << ans;
    system("pause");
    return 0;
}