package 算法入门;

import java.util.Scanner;

public class 分核桃 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        for (int i = 0; i < Math.pow(30,3); i++) {
            if (i>=a&&i>=b&&i>=c)
                if (i%a==0&&i%b==0&&i%c==0){
                    System.out.println(i);
                    break;
                }
        }
    }
}
