package 啊哈算法.meiju;

import java.util.Scanner;

public class 火柴棍 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int sum=0;
        int c;
        for (int i = 0; i < 1111; i++) {
            for (int j = 0; j < 1111; j++) {
                c=i+j;
                if (count(i)+count(j)+count(c)==n-4){
                    System.out.println(i+"+"+j+"="+c);
                    sum++;
                }
            }
        }
        System.out.println(sum+"个数");
    }
    public static int count(int x){
        int num=0;
        int[] arr={6,2,5,5,4,5,6,3,7,6};//数组判断，下标代表数，对应下标的值代表返回个数
        while (x/10!=0){//如果不是个位数进入循环
            num+=arr[x%10];//记录个位数的火柴数
            x/=10;//去掉个位
        }
        num+=arr[x];//最高位
        return num;
    }
}
