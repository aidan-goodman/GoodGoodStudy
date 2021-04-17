package 省赛真题.T2020;

import java.util.Scanner;

public class 合并检测 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum,ans = 0;//sum为检测盒的总数
        int min=99999;
        int n=sc.nextInt();//n表示人数
        for (int k = 1; k <= n; k++) {//从1开始
            if (100%k==0)//如果能平价分组的话
                sum=n/k+k*(n/100);//分组后的组数加上患病人需要的检测盒（1%的几率）
            else
                sum=n/k+1+k*(n/100);
            if (sum<min){
                min=sum;
                ans=k;
            }
        }
        System.out.println(ans);
    }
}
