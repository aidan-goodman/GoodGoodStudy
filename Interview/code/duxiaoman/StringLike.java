package duxiaoman;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/9/5 16:32
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class StringLike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();
        while (m-- != 0) {
            String test = scanner.nextLine();
            char[] strArr = str.toCharArray();
            char[] testArr = test.toCharArray();
            boolean flag = true;
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j] == 'X' && testArr[j] == '1') {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
