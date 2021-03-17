#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Student
{
    string Id, name;
    int score;
};
int c;
bool cmp(Student a, Student b)
{
    if (c == 1)
    {
        return a.Id < b.Id;
    }
    else if (c == 2)
    {
        return a.name == b.name ? a.Id < b.Id : a.name <= b.name;
    }
    else if (c == 3)
    {
        return a.score == b.score ? a.Id < b.Id : a.score <= b.score;
    }
    return 0;
}

int main()
{
    int n;
    vector<Student> stu;
    scanf("%d%d", &n, &c);
    for (int i = 0; i < n; i++)
    {
        Student temp;
        cin >> temp.Id >> temp.name >> temp.score;
        stu.push_back(temp);
    }
    sort(stu.begin(), stu.end(), cmp);
    for (int i = 0; i < stu.size(); i++)
    {
        printf("%s %s %d\n", stu[i].Id.c_str(), stu[i].name.c_str(), stu[i].score);
    }
    system("pause");
    return 0;
}