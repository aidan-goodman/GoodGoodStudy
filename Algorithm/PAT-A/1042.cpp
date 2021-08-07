#include <cstdio>
#include <cstdlib>

int main()
{
    int times;
    scanf("%d", &times); //输入洗牌几次
    int start[55], end[55], order[55];
    for (int i = 1; i < 55; i++)
    {
        scanf("%d", &order[i]); //输入洗牌规则
        start[i] = i;           //初始化默认排序
    }
    for (int i = 0; i < times; i++)
    {
        for (int j = 1; j < 55; j++)
        {
            end[order[j]] = start[j]; //根据规则洗牌
        }
        for (int k = 1; k < 55; k++)
        {
            start[k] = end[k]; //将每次洗完的牌放到初始数组，为下一次洗牌做准备
        }
    }
    char color[5] = {'S', 'H', 'C', 'D', 'J'}; //字符花色数组
    for (int i = 1; i < 55; i++)
    {
        end[i]--;
        //每次的序号都要自减，防止13、26…这样的数字除和摸出13时得到的值不符合逻辑
        printf("%c%d", color[end[i] / 13], end[i] % 13 + 1);
        if (i != 54)
        { //避免额外空格
            printf(" ");
        }
    }
    system("pause");
    return 0;
}