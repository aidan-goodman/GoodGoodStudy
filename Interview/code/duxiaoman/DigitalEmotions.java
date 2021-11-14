package duxiaoman;

import java.util.Scanner;

/**
 * Created by Aidan on 2021/9/5 14:22
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 * @author Aidan
 */

// https://blog.csdn.net/knight20160302/article/details/89647342

public class DigitalEmotions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int number = scanner.nextInt();
            int temp = number;
            boolean great = true;
            boolean happy = false;
            while (temp > 0) {
                if (number % (temp % 10) == 0) {
                    happy = true;
                } else {
                    great = false;
                }
                temp /= 10;
            }
            if (great){
                System.out.println("G");
            }else if(happy){
                System.out.println("H");
            }else {
                System.out.println("S");
            }
        }
    }
}
