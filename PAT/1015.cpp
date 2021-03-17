#include <cstdio>
#include <cmath>
#include <iostream>
#include <algorithm>
using namespace std;

bool isprime(int n)
{
    if (n <= 1)
    {
        return false;
    }
    int sqr = int(sqrt(n * 1.0));
    for (int i = 2; i <= sqr; i++)
    {
        if (n % i == 0)
        {
            return false;
        }
    }
    return true;
}

int main()
{
    int n, radix;
    while (scanf("%d", &n) != EOF)
    {
        scanf("%d", &radix);
        int len = 0, arr[100];
        do
        {
            arr[len++] = n % radix;
            n = n / radix;
        } while (n != 0);
        for (int i = len - 1; i >= 0; i--)
        {
            n = n * radix + arr[i];
        }
        cout<<n;
    }
    return 0;
}