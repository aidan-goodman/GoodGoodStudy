package qianxin;

import java.util.*;

/**
 * Created by Aidan on 2021/10/16 15:44
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Calculation {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(backTrack(str.toCharArray(), map));

    }

    public static int backTrack(char[] chars, Map<Character, Integer> map) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opes = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) {
                for (int j = i; j < chars.length; j++) {
                    if (')' == chars[j]) {
                        int num = backTrack(Arrays.copyOfRange(chars, i + 1, j), map);
                        nums.push(num);
                        i = j;
                    }
                }
                break;

            } else if (isOpe(chars[i])) {
                if (!opes.isEmpty() && map.get(chars[i]) < map.get(opes.peek())) {
                    int y = nums.pop(), x = nums.pop();
                    char ope = opes.pop();
                    int newNum = Calculator(x, y, ope);
                    nums.push(newNum);
                }
                opes.push(chars[i]);
            } else if (i < chars.length - 1 && isOpe(chars[i + 1])) {
                nums.push((int) chars[i] - 48);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = i; j < chars.length; j++) {
                    if (isOpe(chars[j])) {
                        break;
                    }
                    stringBuilder.append(chars[j]);
                    i = j;
                }
                nums.push(Integer.parseInt(stringBuilder.toString()));
            }
        }

        while (!nums.isEmpty() && !opes.isEmpty()) {
            int y = nums.pop(), x = nums.pop();
            char ope = opes.pop();
            int newNum = Calculator(x, y, ope);
            nums.push(newNum);
        }

        return nums.peek();
    }

    public static boolean isOpe(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    public static int Calculator(int x, int y, char c) {
        switch (c) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return -1;
    }
}
