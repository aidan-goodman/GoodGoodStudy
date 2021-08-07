package 算法入门;

import java.util.Scanner;

public class 字符串的输入输出处理 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//读取输入N后的换行符
//先将前n行按原样输出
        for(int i = 0;i < n;i++){
            String str = sc.nextLine();
            System.out.println(str + "\n");
        }
//再将余下的字符串（不含有空格）以空格或回车分割依次按行输出。
        while(sc.hasNext()){
            String s = sc.next();
            System.out.println(s + "\n");
        }
    }
}