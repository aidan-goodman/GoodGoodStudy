package 算法入门;

import java.util.Scanner;

public class 龟兔赛跑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        int t = sc.nextInt();
        int s = sc.nextInt();
        int l = sc.nextInt();
        int t1 = 0, t2 = 0, s1 = 0, s2 = 0;//分别定义兔子和乌龟的时间与路程
        while (s1 < l && s2 < l) {//双方都没到终点线
            if (s1 - s2 < t) {//兔子没有领先指定距离
                t1++;
                t2++;
                s1 = t1 * v1;
                s2 = t2 * v2;
            } else {//兔子领先t
                int tmp = 0;//定义一个临时时间变量，因为乌龟可能最后过线时不需要s秒
                while (s2 < l && tmp < s) {
                    t2++;
                    tmp++;
                    s2 = v2 * t2;
                }
            }
        }
        if (s1 == s2)
            System.out.println("D");
        else if (s1 < s2)
            System.out.println("T");
        else
            System.out.println("R");
        System.out.println(t2);//兔子的时间有停滞，输出乌龟的时间
    }
}