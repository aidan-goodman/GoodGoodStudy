#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<string> list;
    for (int i = 0; i < n; i++) //建立人数循环
    {
        string name, password;
        cin >> name >> password;
        int flag = 0;
        for (int j = 0; j < password.length(); j++)
        {
            switch (password[j]) //依次更换符合要求的值
            {
            case '1':
                password[j] = '@';
                flag = 1;
                break; //这里的break不是跳出循环，而是不执行后面的判断
            case '0':
                password[j] = '%';
                flag = 1;
                break;
            case 'l':
                password[j] = 'L';
                flag = 1;
                break;
            case 'O':
                password[j] = 'o';
                flag = 1;
                break;
            }
        }
        if (flag) //被更改则放入数组
        {
            string temp = name + " " + password;
            list.push_back(temp);
        }
    }
    if (list.size()) //数组中有元素就输出被更改的元素
    {
        cout << list.size() << endl;
        for (int i = 0; i < list.size(); i++)
            cout << list[i] << endl;
    }
    else if (n == 1)
    {
        printf("There is 1 account and no account is modified");
    }
    else
    {
        printf("There are %d accounts and no account is modified", n);
    }
    system("pause");
    return 0;
}