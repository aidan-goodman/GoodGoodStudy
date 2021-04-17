package 省赛真题.T2017;

import java.util.Arrays;
import java.util.Scanner;

public class 承重计算 {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        long[][] arr=new long[30][30];
        long factor=1;
        for (int i = 0; i < 30; i++) {
            factor<<=1;//2位运算，2的30次幂
        }
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                int a=Input.nextInt();//输入
                arr[i][j]=a*factor;//将输入乘以倍数
            }
        }
        System.out.println();
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j <= i; j++) {
                long half=arr[i][j]/2;
                arr[i+1][j]+=half;
                arr[i+1][j+1]+=half;
            }
        }
        Arrays.sort(arr[29]);//对最后的称进行排列
        System.out.println(arr[29][0]/2+","+arr[29][29]/2);
    }
}
