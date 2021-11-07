package quna;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/13 18:42
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

// 计算一个可能会嵌套的字符串（未解）

public class BracketOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (char aChar : chars) {
            if (aChar!=' '){
                stringBuilder.append(aChar);
            }
        }
        int result = backTrack(stringBuilder.toString());
        System.out.println(result);
    }

    private static int backTrack(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isA(chars[i])) {
                if (chars[i + 1] != '(') {
                    int j = i + 1, temp = chars[j]-48;
                    while (chars[++j] != ')') {
                        switch (chars[i]) {
                            case '+':
                                temp += chars[j]-48;
                                break;
                            case '-':
                                temp -= chars[j]-48;
                                break;
                            case '*':
                                temp *= chars[j]-48;
                                break;
                            case '/':
                                temp /= chars[j]-48;
                                break;
                        }
                    }
                    return temp;
                }
            }
        }
        return 0;

    }

    private static boolean isA(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


}
