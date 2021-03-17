#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

struct Student
{
    string name, Id;
    int score;
};

bool cmp(Student a, Student b)
{
    return a.score > b.score;
}

int main()
{
    int n;
    cin >> n;
    vector<Student> stu;
    Student temp;
    for (int i = 0; i < n; i++)
    {
        cin >> temp.name >> temp.Id >> temp.score;
        stu.push_back(temp);
    }
    int low, height;
    int count = 0;
    cin >> low >> height;
    for (int i = 0; i < stu.size(); i++)
    {
        if (stu[i].score < low || stu[i].score > height)
        {
            stu[i].score = -1;
        }
        else
        {
            count++;
        }
    }
    if (count)
    {
        sort(stu.begin(), stu.end(), cmp);
        for (int i = 0; i < count; i++)
        {
            cout << stu[i].name << " " << stu[i].Id << endl;
        }
    }
    else
    {
        cout << "NONE\n";
    }
    system("pause");
    return 0;
}