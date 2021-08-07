#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int per[n], temp, ans = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> temp; //将输入的数作为下标，第几次输入作为位置
        per[temp] = i;
    }
    for (int i = 0; i < n; i++)
    {
        if (i != per[i]) //当各个数字没有归位
        {
            while (per[0] != 0) //0没有归位便进行调换
            {
                swap(per[0], per[per[0]]); //将0所在的位置和其应当存在的的数进行交换
                ans++;
            }
            if (i != per[i]) //一轮调换未能匹配，将0换入不匹配的位置
            {
                swap(per[0], per[i]);
                ans++;
            }
        }
    }
    cout << ans;
    system("pause");
    return 0;
}