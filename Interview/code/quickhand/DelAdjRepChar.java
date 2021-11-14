package quickhand;

/**
 * Created by Aidan on 2021/10/8 15:21
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class DelAdjRepChar {
    public static void main(String[] args) {
        String s = "abbaca";
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }
        System.out.println(stack);

        /* 简洁解法
        String str = "abbaca";
        char[] chars = str.toCharArray();
        int top = -1;
        for (int i = 0; i < str.length(); i++) {
            if (top == -1 || chars[top] != chars[i]) {
                chars[++top] = chars[i];
            } else {
                top--;
            }
        }
        System.out.println(String.valueOf(chars, 0, top + 1));
        */
    }
}
