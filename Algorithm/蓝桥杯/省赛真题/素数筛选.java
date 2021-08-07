package 算法入门;

import java.util.Scanner;

public class 素数筛选 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean bl=true;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < i; j++) {
                if (i%j==0)//如果能整除其他数说明不是素数
                    bl=false;
            }
            if (bl)
                System.out.println(i);
            bl=true;
        }
    }
}
