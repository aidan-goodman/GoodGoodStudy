package 算法入门;

import java.util.Scanner;

public class 乘法运算 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.printf("%4d\n×%3d\n",a,b);//按格式输出
        System.out.println("━━━");//输出下划线（复制过来）
        if (b>=10){//首先判断乘数是否为两位数
            if (b%10==0)//如果个位数等于0的话
                System.out.println("  00");//直接输出00顶右边
            else
                System.out.printf("%4d\n",(b%10)*a);//用b的个位*a
            System.out.printf("%3d\n",(b/10)*a);//格式化输出乘以十位数的乘积，比个位的乘积靠前
            System.out.println("━━━");
        }
        System.out.printf("%4d\n",a*b);
    }
}
