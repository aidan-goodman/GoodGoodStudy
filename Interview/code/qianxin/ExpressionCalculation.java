package qianxin;

import java.util.*;

/**
 * Created by Aidan on 2021/10/21 18:43
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class ExpressionCalculation {
    public static void main(String[] args) {
        System.out.println(transReversePoland(List.of("(", "56", "-", "20", ")",
                "/", "(", "4", "+", "2", ")")));
    }

    public static List<String> transReversePoland(List<String> strings) {
        // 使用 map 存储操作符优先级
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);

        Stack<String> stack = new Stack<>(); // 符号栈
        List<String> stringList = new ArrayList<>(); // 储存中间结果的Lists2
        //遍历ls
        for (String item : strings) {
            if (item.matches("\\d+")) {
                stringList.add(item);
            } else if (item.equals("(")) {
                stack.push(item);
            } else if (item.equals(")")) {
                while (!stack.peek().equals("(")) {
                    stringList.add(stack.pop());
                }
                stack.pop();// 将 ( 弹出 s1栈， 消除小括号
            } else {
                while (!stack.isEmpty() && !stack.peek().equals("(") &&
                        !(map.get(stack.peek()) < map.get(item))) {
                    System.out.println(stack.pop());
                    stringList.add(stack.pop());
                }
                stack.push(item);
            }
        }
        //对应7、8步
        while (stack.size() != 0) {
            stringList.add(stack.pop());
        }
        return stringList;
    }
}
