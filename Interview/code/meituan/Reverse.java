package meituan;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/17 11:44
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

// https://www.cnblogs.com/liujinhong/p/5364410.html

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int m = scanner.nextInt();
            int y = scanner.nextInt();
            boolean flag = true;
            for (int j = 1; Math.pow(a, j) > 0; j++) {
                if (Math.pow(a, j) % m == y) {
                    System.out.println(j);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(-1);
            }
        }
    }
}

/*
小美打算去食堂吃点饭。

小美发现食堂里有很多个窗口，每个窗口前都可能有人在排队。她排队的时候有些好奇这些人排队的规律，于是将食堂排队的各种事件记录下来。现在，有了这些记录，小美想请你帮忙还原一下之前的情景。

小美描述了m个事件，初始时n个窗口都是空的。小美的事件有如下两种：

Opt=1，有一个班级编号为y的人排在了第x个窗口的队尾。(1 <= x <= n)

Opt=2，第x个窗口的队首的同学打好了饭离开了队伍。(1 <= x <= n)



输入描述
第一行两个整数n和m，表示窗口数以及事件数。

接下来m行，每行一个操作。

第一个数是Opt，如果Opt=1，接下来会有两个数x和y；如果Opt=2，接下来只有一个数x

数字间均有空格隔开

输出描述
对于每一个Opt=2的事件，输出一行一个数，表示那个离开窗口的同学的班级编号。如果此次事件之前该队伍就已经空了，则认定此次事件错误并输出-1


样例输入
10 6
1 2 5
1 2 7
1 3 1
2 2
2 3
2 1
样例输出
5
1
-1

提示
数据范围和说明

对于60%的数据，食堂窗口个数n满足 1 <= n <= 1,000，事件个数满足 1 <= m <= 500

对于100%的数据，食堂窗口个数n满足 1 <= n <= 1,000,000,000，事件个数满足 1 <= m <= 500
 */
