#include <iostream>
#include <cctype>
#include <vector>
using namespace std;

string let[26][7], str; //保存图形样式，保存目标字符串
vector<int> word;       //保存每个符合条件的单词

int main()
{
    for (int i = 0; i < 26; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            cin >> let[i][j];
        }
    }
    cin.ignore(); //目标字符串要获取整行，忽略上一个换行
    getline(cin, str);
    bool flag = false; //标记是否有单词被输出
    for (int i = 0; i < str.length(); i++)
    {
        if (isupper(str[i]) && i == str.size() - 1) //存在最后一个的情况
        {
            word.push_back(str[i] - 'A');
        }

        if (isupper(str[i]) && i != str.size() - 1) //用非大写字母或者结尾进行一次输出
        {
            word.push_back(str[i] - 'A');
        }
        else
        {
            if (flag) //判断之前是否有单词被输出
            {
                cout << endl
                     << endl;
                flag = false;
            }

            for (int j = 0; j < 7; j++) //每个单词输出7行
            {
                for (int k = 0; k < word.size(); k++) //输出每个单词的每一行
                {
                    if (k != 0) //空格相隔
                    {
                        cout << " ";
                    }
                    cout << let[word[k]][j];
                }
                if (j != 6) //换行
                {
                    cout << endl;
                }
            }
            word.clear(); //清空保存数组进行下一次输出
            flag = true;
        }
    }

    system("pause");
    return 0;
}