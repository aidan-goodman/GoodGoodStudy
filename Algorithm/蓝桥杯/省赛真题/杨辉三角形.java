package 算法入门;

import java.util.Scanner;

public class 杨辉三角形 {
    public static void main(String[] args) {
        Scanner Input=new Scanner(System.in);
        int n=Input.nextInt();
        for(int i =0;i<n;i++) {
            int number = 1;
            for(int j=0;j<=i;j++) {
                System.out.print(number+" ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
