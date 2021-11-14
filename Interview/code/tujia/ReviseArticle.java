package tujia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Aidan
 * @createTime 2021/11/13 14:55
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class ReviseArticle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(s1));

        Collections.reverse(strings);

        int i = 0;
        for (String string : strings) {
            i++;
            if (string.contains(",")) {
                String[] split = string.split(",");
                System.out.print(split[1]);
                System.out.print(",");
                System.out.print(split[0]);
            } else if (string.contains(".")) {
                String[] split = string.split("\\.");
                if (split.length == 1) {
                    System.out.print(".");
                    System.out.print(string.replace('.', ' '));
                    continue;
                } else {
                    System.out.print(split[1]);
                    System.out.print(".");
                    System.out.print(split[0]);
                }
            } else {
                System.out.print(string);
            }
            if (i < strings.size()) {
                System.out.print(" ");
            }
        }

    }
}
