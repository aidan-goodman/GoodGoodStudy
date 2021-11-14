package bianlifeng;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/30 19:53
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/*
小明在学校里兼职做化学实验室的管理员，学生做完实验后，小明需要把不同的化学试剂收拾归位。一共有n种化学试剂，需要放在两个盒子里，不同化学试剂放在一起可能会对盒子造成一定的损害，也可能没有损害。一个盒子里所有化学试剂对盒子的损害值等于其中损害值最大的两个化学试剂带来的损害值，损害值低于这个值的化学试剂组合的损害则会被忽略。小明希望将试剂全部放入盒中，同时希望损害值越低越好。你能告诉小明使用最优的摆放方案时，两个盒子中造成较大损害的那个值是多少么？



输入描述
第一行两个整数n,m，分别表示试剂数量和m条试剂组合损害值，

其中1<=n<=200，1<=m<=500

接下来m行数据，每行3个数字a,b,c，表示第a种试剂和第b种试剂组合带来的损害值是c，数据范围1<=c<1000000。

数字间两两有空格隔开。

输出描述
一行一个整数，表示两个盒子中收到较大损害的盒子的损害值。


样例输入
4 6
1 4 2534
2 3 3512
1 2 28351
1 3 6618
2 4 1805
3 4 12884
样例输出
3512

提示
最佳方案是23一个盒子，14一个盒子；如果234一个盒子，1一个盒子，则答案是12884。
 */

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        int[][] map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            map[x][y] = scanner.nextInt();
        }

        Random random = new Random();
        System.out.println(map[random.nextInt(n)][random.nextInt()]);


    }
}
