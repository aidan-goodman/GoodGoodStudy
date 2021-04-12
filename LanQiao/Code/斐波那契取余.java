package 算法入门;

import java.util.Scanner;

public class 斐波那契取余 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long F=1,F1=1,F2=1,n;
        n=input.nextLong();
        if (n>2){
            for(long i=3;i<=n;i++){
                F=(F1+F2)%10007;
                F1=F2;
                F2=F;
            }
        }
        System.out.println(F);
    }
}