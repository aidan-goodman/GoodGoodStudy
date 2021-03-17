#include <iostream>
#include <cstdio>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

struct Record //结构体记录每条通话记录的信息，名字是公共的所以无需放入
{
    string status;
    int month, day, hour, minute, time; //time表示的是开年零点到现在的时间（分钟为单位）
};

bool cmp(Record a, Record b) //定义一个时间的排序规则
{
    return a.time < b.time;
}

int main()
{
    double rate[24]; //输入收费标准，时间也是从0开始，无需进行下标的增减
    for (int i = 0; i < 24; i++)
    {
        cin >> rate[i];
    }
    int n;
    cin >> n;
    getchar();                          //后边输入字符串，截获换行符
    map<string, vector<Record>> custom; //用名字作为键值，直接对其进行排序
    for (int i = 0; i < n; i++)
    {
        Record temp;
        string temp_name; //作为键放入Map，临时变量即可
        cin >> temp_name;
        //cin>> temp.month >> temp.day >> temp.hour >> temp.minute;
        //这种输出对有":"间隔的数据无法处理，可以加一个char c截获,或使用下面scanf的方式输入
        scanf("%d:%d:%d:%d", &temp.month, &temp.day, &temp.hour, &temp.minute);
        cin >> temp.status;
        temp.time = temp.day * 1440 + temp.hour * 60 + temp.minute; //统一转换成分钟方便运算
        custom[temp_name].push_back(temp);                          //以姓名为键，记录数组为值放入集合
    }
    for (auto it : custom)
    {
        auto temp_V = it.second;                 //将每个人的通话记录数组拿出来，对每个数组进行处理
        sort(temp_V.begin(), temp_V.end(), cmp); //对所有的通话记录进行排序
        double total_bill = 0;
        for (int i = 0; i < temp_V.size();) //分组判断，不直接递增
        {
            if (i + 1 < temp_V.size() && temp_V[i].status > temp_V[i + 1].status) //on按字典序高于off，一组符合规则的数据
            {
                if (!total_bill) //使用非的方式只输出一次姓名，后续total有值便为0
                {
                    cout << it.first;
                    printf(" %02d\n", temp_V[i].month);
                }
                double per_bill = 0;
                int time1 = temp_V[i].time, time2 = temp_V[i + 1].time;
                for (int j = time1; j < time2; j++) //模拟时间
                {
                    per_bill += rate[j % 1440 / 60]; //每分钟的单价相加
                }
                printf("%02d:%02d:%02d ", temp_V[i].day, temp_V[i].hour, temp_V[i].minute);
                printf("%02d:%02d:%02d ", temp_V[i + 1].day, temp_V[i + 1].hour, temp_V[i + 1].minute);
                printf("%d $%.2f\n", temp_V[i + 1].time - temp_V[i].time, per_bill / 100);
                total_bill += per_bill;
                i += 2; //一组成功下一组
            }
            else
            {
                i++; //一组不成功，以结束时间作为下一组的开始时间
            }
        }
        if (total_bill) //这个是在人物之外，还需判断一次，防止有人存在的账单都不符合条件但还是输出了total_bill
        {
            printf("Total amount: $%.2f\n", total_bill / 100); //账单以时间为单位
        }
    }
    system("pause");
    return 0;
}