#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

/*
int main()
{
    int n, m;
    scanf("%d%d", &n, &m);
    map<int, vector<string>> list;
    char name[5];
    for (int i = 0; i < n; i++)
    {
        int k;
        scanf("%s %d", name, &k);
        for (int j = 0; j < k; j++)
        {
            int temp;
            scanf("%d", &temp);
            list[temp].push_back(name);
        }
    }

    for (int i=1;i<=m;i++)
    {
        vector<string> str = list[i];
        printf("%d %d\n", i, str.size());
        sort(str.begin(), str.end());
        for (int j = 0; j < str.size(); j++)
        {
            printf("%s\n",str[j].c_str());
        }
    }
    system("pause");
    return 0;
}
*/

int n, k, c, idx;
vector<vector<string>> course;

int main()
{
    scanf("%d%d", &n, &k);
    course.resize(k + 1);
    for (int i = 0; i < n; ++i)
    {
        string name;
        cin >> name >> c;
        for (int j = 0; j < c; ++j)
        {
            scanf("%d", &idx);
            course[idx].push_back(name);
        }
    }
    for (int i = 1; i <= k; ++i)
    {
        printf("%d %d\n", i, course[i].size());
        sort(course[i].begin(), course[i].end());
        for (int j = 0; j < course[i].size(); ++j)
            printf("%s\n", course[i][j].c_str());
    }
    return 0;
}