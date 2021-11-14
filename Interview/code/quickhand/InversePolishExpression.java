package quickhand;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Aidan on 2021/10/8 17:05
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class InversePolishExpression {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) ||
                "/".equals(token));
    }

    @Test
    void test() {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*",
                "/", "*", "17", "+", "5", "+"}));
    }
}
