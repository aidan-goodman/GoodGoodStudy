#include <iostream>
#include <cstdio>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

struct Person
{
    char name[10]; //使用字符数组，配合scanf()减少复杂度
    int age, money;
};

bool cmp(Person a, Person b)
{
    if (a.money != b.money)
    {
        return a.money >= b.money;
    }
    else if (a.age != b.age)
    {
        return a.age <= b.age;
    }
    else
    {
        return strcmp(a.name, b.name) <= 0; //字符数组的排序
    }
}

int main()
{
    int n, k;
    scanf("%d %d", &n, &k);
    vector<Person> temp_in(n); //输入数组
    for (int i = 0; i < n; i++)
    {
        scanf("%s %d %d", &temp_in[i].name, &temp_in[i].age, &temp_in[i].money);
    }
    sort(temp_in.begin(), temp_in.end(), cmp); //排序
    vector<int> book(201, 0);
    vector<Person> people;
    for (int i = 0; i < n; i++)
    {
        if (book[temp_in[i].age] < 100) //每个年龄都不超过100人
        {
            people.push_back(temp_in[i]); //缩小数据放到新数组
            book[temp_in[i].age]++;
        }
    }
    int m, Amin, Amax; //将循环输入的变量放到循环外减少语句量
    for (int i = 0; i < k; i++)
    {
        scanf("%d %d %d", &m, &Amin, &Amax);
        vector<Person> temp_out;
        for (int j = 0; j < people.size(); j++)
        {
            if (people[j].age >= Amin && people[j].age <= Amax)
            {
                temp_out.push_back(people[j]); //将符合条件的放入输出数组
            }
        }
        printf("Case #%d:\n", i + 1);
        bool flag = false;
        for (int l = 0; l < m && l < temp_out.size(); l++) //有不足m的情况，加一个大小的判断条件
        {
            printf("%s %d %d\n", temp_out[l].name, temp_out[l].age, temp_out[l].money);
            flag = true;
        }
        if (!flag)
        {
            printf("None\n");
        }
    }
    system("pause");
    return 0;
}