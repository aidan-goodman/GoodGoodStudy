package 省赛真题.T2020;

import java.util.HashMap;
import java.util.Scanner;

public class 解密 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Character,Character> hashMap=new HashMap<>();
        for (int i = 0; i < 52; i++) {
            char a=sc.next().trim().charAt(0);
            //sc.next()返回一个String类型对象
            //.trim()去掉空格
            //.charAt()返回一个char型
            char b=sc.next().trim().charAt(0);
            hashMap.put(b,a);//put添加，b为键，a为值
        }
        char[] num=sc.next().toCharArray();//输入加密字符
        for (char m:num)//m必须为char型
            System.out.print(hashMap.get(m));
    }
}
