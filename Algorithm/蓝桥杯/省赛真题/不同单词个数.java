package 算法入门;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 不同单词个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();//读取字符串
        String [] str = string.split(" ");//用空格隔开放到string数组中
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < str.length; i++) {
            set.add(str[i]);//放入set集合中去重
        }
        System.out.println(set.size());//输出集合的大小
    }
}
