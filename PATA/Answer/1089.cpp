#include <iostream>
#include <algorithm>
using namespace std;

int origin[100], tempOri[100], changed[100]; //初始数组，初始备份，目标数组
int n;

bool isSame(int a[], int b[]) //判断数组相同
{
    for (int i = 0; i < n; i++)
    {
        if (a[i] != b[i])
        {
            return false;
        }
    }
    return true;
}

void showArr(int a[]) //输出方法
{
    for (int i = 0; i < n - 1; i++)
    {
        cout << a[i] << " ";
    }
    cout << a[n - 1];
}

bool insertSort() //使用布尔型，返回false表示其为归并
{
    bool flag = false;
    for (int i = 1; i < n; i++) //从第二个元素开始插入
    {
        if (i != 1 && isSame(tempOri, changed)) //抛开第一次即相同的情况下相同
        {
            flag = true; //判断相同再排序一次，方便输出next序列
        }
        //插入排序核心代码
        int j = i, temp = tempOri[i];
        while (j != 0 && tempOri[j - 1] > temp)
        {
            tempOri[j] = tempOri[j - 1];
            j--;
        }
        tempOri[j] = temp;

        if (flag) //当判断成功直接跳出
        {
            break;
        }
    }
    return flag;
}

void mergeSort() //不是插入排序直接使用归并方法
{
    bool flag = false;
    for (int step = 2; step / 2 <= n; step *= 2) //归并的遍历方式
    {
        if (step != 2 && isSame(origin, changed)) //抛开第一次即相同的情况下相同
        {
            flag = true;
        }
        for (int i = 0; i < n; i += step) //对每组进行排序
        {
            sort(origin + i, origin + min(i + step, n)); //直接使用sort方法即可
        }
        if (flag)
        {
            showArr(origin);
            break; //在循环中结束记得跳出
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> origin[i];
        tempOri[i] = origin[i];
    }
    for (int i = 0; i < n; i++)
    {
        cin >> changed[i];
    }

    if (insertSort())
    {
        cout << "Insertion Sort" << endl;
        showArr(tempOri);
    }
    else
    {
        cout << "Merge Sort" << endl;
        mergeSort();
    }

    system("pause");
    return 0;
}