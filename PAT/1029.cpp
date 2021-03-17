#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> sequeN, sequeM;
    int temp;
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        sequeN.push_back(temp);
    }
    int m;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> temp;
        sequeM.push_back(temp);
    }
    int median = (n + m - 1) / 2;
    sequeN[n] = sequeM[m] = (1 << 31) - 1;//将数组边界设置为2^31-1
    int i = 0, j = 0, count = 0;
    while (count < median)
    {
        if (sequeN[i] < sequeM[j])
        {
            i++;
        }
        else
        {
            j++;
        }
        count++;
    }
    if (sequeN[i] < sequeM[j])
    {
        cout << sequeN[i];
    }
    else
    {
        cout << sequeM[j];
    }

    system("pause");
    return 0;
}