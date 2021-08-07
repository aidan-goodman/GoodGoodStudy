#include <iostream>
using namespace std;

int main()
{
    int t1, t2, t3;
    char c[14] = {"0123456789ABC"};
    cin >> t1 >> t2 >> t3;
    cout << '#';
    cout << c[t1 / 13] << c[t1 % 13];
    cout << c[t2 / 13] << c[t2 % 13];
    cout << c[t3 / 13] << c[t3 % 13];
    system("pause");
    return 0;
}