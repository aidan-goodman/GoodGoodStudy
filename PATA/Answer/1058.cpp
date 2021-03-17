#include <cstdio>
#include <cstdlib>

int main()
{
    int a1, b1, c1, a2, b2, c2, a, b, c;
    scanf("%d.%d.%d %d.%d.%d", &a1, &b1, &c1, &a2, &b2, &c2);
    c = c1 + c2; //由小位到大位，按位相加，小位留余
    b = b1 + b2 + c / 29;
    c = c % 29;
    a = a1 + a2 + b / 17;
    b = b % 17;
    printf("%d.%d.%d", a, b, c);
    /*
    int yuan, jiao, fen;
    scanf("%d.%d.%d", &yuan, &jiao, &fen);
    int t_y, t_j, t_f;
    scanf("%d.%d.%d", &t_y, &t_j, &t_f);
    yuan += t_y;
    jiao += t_j;
    fen += t_f;
    if (!(fen < 29))
    {
        jiao++;
        fen -= 29;
    }
    if (!(jiao < 17))
    {
        yuan++;
        jiao -= 17;
    }
    printf("%d.%d.%d", yuan, jiao, fen);
    */
    system("pause");
    return 0;
}