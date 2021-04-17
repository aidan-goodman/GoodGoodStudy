package 省赛真题.T2020;

import java.util.Scanner;

public class 走方格 {
    static int n, m, ans;
    static void dfs(int x,int y)
    {
        if(x > n || y > m)
            return;
        if(x%2 == 0 && y%2 == 0)
            return;
        if(x == n && y == m)
            ans++;
        dfs(x + 1,y);
        dfs(x,y+1);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if(n%2 == 0 && m%2 == 0)
            ans = 0;//如果出口偶数行偶数列
        else
            dfs(1,1);
        System.out.println(ans);
    }
}