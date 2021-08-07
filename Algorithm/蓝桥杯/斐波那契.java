package 算法入门;

import java.util.Scanner;

public class 斐波那契 {
    /*递归法
    static int f(int n){
        if(n==0)
            return 0;
        if (n==1)
            return 1;
        return f(n-1)+f(n-2);
    }
     */
    static  long f(long n){
        long F=1,F1=1,F2=1;
        for(long i=3;i<=n;i++){
            F=(F1+F2);
            F1=F2;
            F2=F;
        }
        return F;
    }
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        long n=Input.nextInt();
        long m=Input.nextInt();
        long p=Input.nextInt();
        long sum=f(n+2)-1;
        long ans=sum%f(m);
        System.out.println(ans%p);
    }
}
