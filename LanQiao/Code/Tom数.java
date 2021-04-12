package 算法入门;

import java.util.Scanner;

public class Tom数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i)-'0';//别忘了减“0”
            }
            System.out.println(sum);
        }
    }
}
