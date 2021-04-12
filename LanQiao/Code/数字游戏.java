package 算法入门;

import java.util.Scanner;

public class 数字游戏 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int t=sc.nextInt();
        long t1=1,a=1,sum=t1;//将a设为首项，t1开始为指定人报的第一个数
        for(int i = 1; i < t; ++i)
        {
            t1= (((a+a+n-1)*n/2)+t1)%k;
            //上为等差公式之和，a为首项，a+n-1为末项，公式和加t1（前一位）取余K，为当前位的值
            sum += t1;//将每一个指定位相加
            a += n;//首项每次加N
        }
        System.out.println(sum);
    }
}
