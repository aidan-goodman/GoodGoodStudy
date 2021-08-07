package 省赛真题.T2020;

import java.util.Scanner;

public class 分类计数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int upp = 0, low = 0, dig = 0;
        char[] arr = sc.next().toCharArray();
        for (char m : arr) {
            if (Character.isUpperCase(m))//实用类，记好
                upp++;
            else if (Character.isLowerCase(m))
                low++;
            else if (Character.isDigit(m))
                dig++;
        }
        System.out.println(upp);
        System.out.println(low);
        System.out.println(dig);
    }
}
