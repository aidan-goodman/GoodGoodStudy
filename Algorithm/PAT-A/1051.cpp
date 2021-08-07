#include <iostream>
#include <vector>
#include <stack>
using namespace std;

stack<int> st;
int main()
{
    int m, n, k, arr[1001]; //保存序列
    cin >> m >> n >> k;
    while (k--)
    {
        while (!st.empty()) //将栈清空
        {
            st.pop();
        }
        for (int i = 1; i <= n; i++)
        {
            cin >> arr[i]; //保存序列
        }
        int current = 1;
        bool flag = true;
        for (int i = 1; i <= n; i++)
        {
            st.push(i);
            if (st.size() > m) //当前个数超过容量
            {
                flag = false;
                break;
            }
            while (!st.empty() && st.top() == arr[current]) //每放入一个元素判断出栈
            {
                st.pop();
                current++;
            }
        }
        if (st.empty() && flag) //模拟完成后栈空和容量未超表示正确
        {
            cout << "YES" << endl;
        }
        else
        {
            cout << "NO" << endl;
        }
    }
    return 0;
}