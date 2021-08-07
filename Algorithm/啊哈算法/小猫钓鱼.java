package 啊哈算法.stack_queue_list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 小猫钓鱼 {

    public static void main(String[] args) {
        Stack<Integer> deskStack = new Stack<>();//桌子上的牌，用栈进行管理
        Queue<Integer> playerA = new LinkedList();//用队列管理每个选手的牌
        Queue<Integer> playerB = new LinkedList();
        int book[] = new int[10];
        Scanner scanner = new Scanner(System.in);
        //发牌，每人6张
        for (int i = 0; i < 6; i++) {
            playerA.add(scanner.nextInt());
        }
        for (int i = 0; i < 6; i++) {
            playerB.add(scanner.nextInt());
        }
        //当两个队列都不为空，表示游戏没有结束
        while (!playerA.isEmpty() && !playerB.isEmpty()) {
            int ta = playerA.peek();//A出一张牌
            //判断A出的牌能不能赢牌
            if (book[ta] == 0) {//桌子上没有这张牌
                //A不能赢牌
                playerA.remove();//打出的牌出队列
                deskStack.add(ta);//打出的牌入栈
                book[ta] = 1;//标记打出的牌出现在桌子上
            } else {//A能赢牌
                playerA.remove();//打出的牌出队列
                playerA.add(ta);//打出的牌入队列
                while (deskStack.lastElement() != ta) {
                    book[deskStack.lastElement()] = 0;
                    playerA.add(deskStack.lastElement());
                    deskStack.pop();
                }
            }
            int tb = playerB.peek();//B出一张牌
            //判断B出的牌能不能赢牌
            if (book[tb] == 0) {//桌子上没有这张牌
                //B不能赢牌
                playerB.remove();//打出的牌出队列
                deskStack.add(tb);//打出的牌入栈
                book[tb] = 1;//标记打出的牌出现在桌子上
            } else {//B能赢牌
                playerB.remove();//打出的牌出队列
                playerB.add(tb);//打出的牌入队列
                while (deskStack.lastElement() != tb) {
                    book[deskStack.lastElement()] = 0;
                    playerB.add(deskStack.lastElement());
                    deskStack.pop();
                }
            }
        }
        if (playerA.isEmpty()) {
            System.out.println("B赢了");
            System.out.print("B手中的牌为：");
            while (!playerB.isEmpty()) {
                System.out.print(playerB.peek() + " ");
                playerB.remove();
            }
        } else {
            System.out.println("A赢了");
            System.out.print("A手中的牌为：");
            while (!playerA.isEmpty()) {
                System.out.print(playerA.peek() + " ");
                playerA.remove();
            }
        }
        System.out.println("");
        System.out.print("桌子上的牌为：");
        while (!deskStack.isEmpty()) {
            System.out.print(deskStack.lastElement() + " ");
            deskStack.pop();
        }
    }
}
