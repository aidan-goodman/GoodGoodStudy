#include <cstdio>
#include <cstring>
#include <cstdlib>

int main()
{
    //数组型
    char str[81], map[30][30];     //创建一个二维数组
    memset(map, ' ', sizeof(map)); //全部初始化为空格
    scanf("%s", str);
    int length = strlen(str) + 2;
    int row = length / 3;
    int column = length - 2 * row;
    for (int i = 0; i < row - 1; i++)
    {
        map[i][0] = str[i];
        map[i][column - 1] = str[length - 3 - i];
    }
    for (int i = 0; i < column; i++)
    {
        map[row - 1][i] = str[row - 1 + i];
    } //对二维数组填充
    for (int i = 0; i < row; i++)
    {
        for (int j = 0; j < column; j++)
        {
            printf("%c", map[i][j]);
        }
        if (i != row - 1)
        {
            printf("\n");
        }
    }
    printf("\n");
    //直接输出型
    int n = strlen(str);
    int n1 = (n + 2) / 3, n3 = n1, n2 = (n + 2) - 2 * n1; //确定n1,n2,n3的长度，n1和n3一个就够
    for (int i = 0; i < n1 - 1; i++)
    { //输出没有底层的所有
        printf("%c", str[i]);
        for (int j = 0; j < n2 - 2; j++)
        {
            printf(" ");
        }
        printf("%c\n", str[n - 1 - i]);
    }
    for (int i = 0; i < n2; i++)
    { //输出底层
        printf("%c", str[n1 - 1 + i]);
    }
    system("pause");
    return 0;
}