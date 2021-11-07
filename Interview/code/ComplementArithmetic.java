package alibaba;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/10/8 20:06
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

/*
2
00000000000000000000000000000101 11111111111111111111111111111111
00000000000000000000000000011111 00000000000000000000000000000111
 */

public class ComplementArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            String a = scanner.next();
            String b = scanner.next();
            int x=hand(a),y=hand(b);
            System.out.println(x+y);
        }
    }

    public static int hand(String str) {
        char[] chars = str.toCharArray();
        int m = 0;
        if (chars[0] == '0') {
            m = Integer.parseInt(str, 2);
        } else {
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '1') {
                    chars[i] = '0';
                } else {
                    chars[i] = '1';
                }
            }
            String newA = String.copyValueOf(chars, 1, 31);
            m = Integer.parseInt(newA, 2)+1;
            if (m > 0) {
                m *= -1;
            }
        }
        return m;
    }
}
