package 省赛真题.T2019;

import java.util.HashSet;
import java.util.Scanner;
/*
题意：一个字符串的非空子串是指字符串中长度至少为1 的连续的一段字符组成的串。
例如，字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共7 个。
注意在计算时，只算本质不同的串的个数。
请问，字符串0100110001010001 有多少个不同的非空子串？
 */
//思路：枚举出所有的起点和终点然后放入hashset中去重
public class 不同字串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        HashSet<String> hashSet=new HashSet<String>();//不存在重复元素
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <=s.length() ; j++) {
                //SubString 包括begin，不包括end，从i的后1位开始枚举
                hashSet.add(s.substring(i,j));
            }
        }
        System.out.println(hashSet.size());
    }
}
