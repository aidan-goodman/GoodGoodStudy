package 省赛真题.T2018;

import java.util.Scanner;
//等差数列公式：an=a1+(n-1)d;Sn=n(a1+an)/2
public class 螺旋折线 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        long x=input.nextLong();
        long y=input.nextLong();
        long n=0;//定义圈数
        long d=0;//长度

        if(y>0&&Math.abs(x)<=y){
            n=y;
            d=y-x+2*y;
        } else if(x>0&&Math.abs(y)<=x){
            n=x;
            d=x+y;
        }else if(y<=0&&x>=y-1&&x<=-y){
            n=-y;
            d=-(-y-x);//将长度转为负数，后边负负得正
        }else if(x<0&&y>=x+1&&y<=-x){
            n=-x-1;
            d=-(y-x-1-2*x-1);
        }
        System.out.println(sum(6,n,8)-d);
        //将两个等差数列合为一个，减去d的值（左下的值为负数即加上）
    }
    public static long sum(long a0,long n,long d){//等差数列求和方法
        return (2*a0+(n-1)*d)*n/2;
    }

}
