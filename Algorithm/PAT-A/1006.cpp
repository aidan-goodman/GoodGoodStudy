#include <iostream>
#include <climits>
using namespace std;

int main()
{
    int n, max = INT_MIN, min = INT_MAX;
    string unlock, lock;
    scanf("%d", &n);            //读入人数
    for (int i = 0; i < n; i++) //建立人数循环
    {
        string Id;
        cin >> Id; //输入每个人的ID
        int h1, m1, s1, h2, m2, s2;
        scanf("%d:%d:%d %d:%d:%d", &h1, &m1, &s1, &h2, &m2, &s2);
        int in_temp = h1 * 3600 + m1 * 60 + s1; //将所有的时间转换成秒
        int out_temp = h2 * 3600 + m2 * 60 + s2;
        if (min > in_temp) //最小的时间就是开锁人
        {
            min = in_temp;
            unlock = Id; //保存ID
        }
        if (max < out_temp) //最大的时间就是锁门人
        {
            max = out_temp;
            lock = Id; //保存ID
        }
    }
    cout << unlock << " " << lock;
    system("pause");
    return 0;
}