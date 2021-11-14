package quickhand;

/**
 * Created by Aidan on 2021/10/10 9:47
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class MaxDepthParentheses {
    public static void main(String[] args) {
        String str = "1+(2*3)/(2-1)";
        int depth = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
                if (count > depth) {
                    depth = count;
                }
            } else if (str.charAt(i) == ')') {
                count--;
            }
        }
        System.out.println(depth);

    }
}
