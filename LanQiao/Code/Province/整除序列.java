package 省赛真题.T2020;

import java.util.Scanner;

public class 整除序列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n!=0){
            System.out.print(n+" ");
            n>>=1;//位运算搞熟
        }
    }
}
