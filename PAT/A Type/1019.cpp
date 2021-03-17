#include <cstdio>
#include <vector>
#include <cstdlib>
using namespace std;

int main()
{
    vector<int> mod;
    int N, k;
    scanf("%d %d", &N, &k);
    /*
    while (!(N < k)) //相等时仍要继续计算，也可以使用N!=0作为判断条件
    {
        mod.push_back(N % k);
        N /= k;
    }
    mod.push_back(N); //将最后的N也放入数组
    */
    while (N)
    { //更简洁的判断条件
        mod.push_back(N % k);
        N /= k;
    }
    bool flag = true;
    for (int i = 0; i < mod.size() / 2; i++)
    { //判读获取的余数数组是不是回文数
        if (mod[i] != mod[mod.size() - 1 - i])
        {
            flag = false;
            break;
        }
    }
    if (flag)
    {
        printf("Yes\n");
    }
    else
    {
        printf("No\n");
    }
    for (auto i = mod.end() - 1; i != mod.begin(); i--)
    { //反向输出
        printf("%d ", *i);
    }
    printf("%d", *mod.begin());
    system("pause");
    return 0;
}