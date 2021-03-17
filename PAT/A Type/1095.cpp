#include <iostream>
#include <unordered_map>
#include <algorithm>
#include <vector>
using namespace std;

struct Record
{
    string p_num, statu;
    int hour, mintue, second, time; //存储当前时间点在一天中是第多少秒
};
unordered_map<string, vector<Record>> msvr; //记录集合
unordered_map<string, int> msi;             //停靠时间集合
int N, K;
int in_school[86400] = {0};  //在这一秒有多少车辆进入
int out_school[86400] = {0}; //在这一秒有多少车辆出去

bool cmp(Record a, Record b)
{
    return a.time < b.time; //时间从早到晚排序
}

int main()
{
    cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        Record temp;
        cin >> temp.p_num;
        scanf("%d:%d:%d", &temp.hour, &temp.mintue, &temp.second);
        cin >> temp.statu;
        temp.time = temp.hour * 3600 + temp.mintue * 60 + temp.second;
        msvr[temp.p_num].push_back(temp); //将每次输入的记录放到车牌号对应的数组中
    }
    for (auto it : msvr) //遍历集合
    {
        auto v = it.second; //将每个车牌号对应的数组取出
        sort(v.begin(), v.end(), cmp);
        for (int i = 0; i < v.size();)
        {
            if (v[i].statu == "in") //进行配对处理
            {
                if (i + 1 < v.size() && v[i + 1].statu == "out")
                {
                    in_school[v[i].time]++; //将in的状态放到对应的时间点
                    out_school[v[i + 1].time]++;
                    msi[it.first] += v[i + 1].time - v[i].time; //统计停车时长
                    i += 2;                                     //下一组
                }
                else
                {
                    i++;
                }
            }
            else
            {
                i++;
            }
        }
    }

    int car_cnt[86400];
    int t = 0;
    for (int i = 0; i < 86400; i++)
    {
        t += in_school[i];
        t -= out_school[i];
        car_cnt[i] = t; //每个时间的车辆==之前所有的进-所有的出
    }

    int t_h, t_m, t_s;
    for (int i = 0; i < K; i++)
    {
        scanf("%d:%d:%d", &t_h, &t_m, &t_s);
        printf("%d\n", car_cnt[t_h * 3600 + t_m * 60 + t_s]);
    }
    int max_time = 0;
    vector<string> maxcars; //存储并列的最久车辆，保存车牌号
    for (auto it : msi)
    {
        if (it.second > max_time)
        {
            max_time = it.second;
            maxcars = {it.first}; //现在是唯一的答案，直接赋值（不使用放入，因为每次赋值都要清空前面所有的）
        }
        else if (it.second == max_time)
        {
            maxcars.push_back(it.first); //现在是并列的答案，放入
        }
    }
    sort(maxcars.begin(), maxcars.end()); //根据字符排序
    for (string each : maxcars)
    {
        cout << each << " ";
    }
    printf("%02d:%02d:%02d", max_time / 3600, max_time / 60 % 60, max_time % 60);
    system("pause");
    return 0;
}