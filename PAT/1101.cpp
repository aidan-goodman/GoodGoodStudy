#include <iostream>
using namespace std;

int main()
{
    int n;
    cin>>n;
    int leftMax[n], rightMin[n], arr[n];
    int ans[n], num = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    leftMax[0] = 0;
    for (int i = 1; i < n; i++)
    {
        leftMax[i] = max(leftMax[i - 1], arr[i - 1]);
    }
    rightMin[n - 1] = 0x3fffffff;
    for (int i = n - 2; i >= 0; i--)
    {
        rightMin[i] = min(rightMin[i + 1], arr[i + 1]);
    }
    for (int i = 0; i < n; i++)
    {
        if (leftMax[i] < arr[i] && rightMin[i] > arr[i])
        {
            ans[num++] = arr[i];
        }
    }
    cout << num << endl;
    for (int i = 0; i < num; i++)
    {
        cout << ans[i];
        if (i < num - 1)
        {
            cout << " ";
        }
    }
    cout << endl;
    system("pause");
    return 0;
}