#include <iostream>
using namespace std;

int flag[100001] = {0}, num[100000]; //flag进行个数统计，num记录输入顺序
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> num[i];
        flag[num[i]]++; //将输入的数作为下标自增
    }
    bool f = true; //判断是否有符合条件的值输出
    for (int i = 0; i < n; i++)
    {
        if (flag[num[i]] == 1)
        {
            cout << num[i];
            f = false; //有输出
            break;
        }
    }
    if (f)
    {
        cout << "None";
    }
    system("pause");
    return 0;
}