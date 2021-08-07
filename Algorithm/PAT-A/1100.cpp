#include <iostream>
#include <map>
#include <cstring>
using namespace std;

string unitDigit[13] = {"tret", "jan", "feb", "mar", "apr", "may", "jun", "jly", "aug", "sep", "oct", "nov", "dec"};
string tenDigit[13] = {"tret", "tam", "hel", "maa", "huh", "tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};
//将个位十位保存
string numToStr[170];      //通过数字作为下标输出字符串
map<string, int> strToNum; //通过字符串映射到数字
void init()
{
    for (int i = 0; i < 13; i++)
    {
        numToStr[i] = unitDigit[i];
        strToNum[unitDigit[i]] = i; //存储个位的互相对应
        numToStr[i * 13] = tenDigit[i];
        strToNum[tenDigit[i]] = i * 13; //存储整十位的互相对应
    }
    for (int i = 1; i < 13; i++)
    { //每位的对应
        for (int j = 1; j < 13; j++)
        {
            string str = tenDigit[i] + " " + unitDigit[j];
            numToStr[i * 13 + j] = str;
            strToNum[str] = i * 13 + j;
        }
    }
}
int main()
{
    init(); //调用打表
    int n;
    cin >> n;
    string query;
    getchar();
    for (int i = 0; i < n; i++)
    {
        getline(cin, query);
        if (query[0] >= '0' && query[0] <= '9')
        {
            int num = stoi(query); //将属于数字的转换为int型
            cout << numToStr[num] << endl;
        }
        else
        {
            cout << strToNum[query] << endl;
        }
    }
    return 0;
}