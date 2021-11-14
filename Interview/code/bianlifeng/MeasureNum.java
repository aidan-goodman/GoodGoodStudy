package bianlifeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Aidan
 * @createTime 2021/10/30 19:24
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */

public class MeasureNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int maxInd = 0, max = Integer.MIN_VALUE, minInd = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                maxInd = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minInd = i;
            }
        }

        List<Integer> maxIndList = new ArrayList<>();
        List<Integer> minIndList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[minInd]) {
                minIndList.add(i);
            }
            if (arr[i] == arr[maxInd]) {
                maxIndList.add(i);
            }
        }
        int result = 0;
        for (Integer maxTemp : maxIndList) {
            maxInd = maxTemp;
            for (Integer minTemp : minIndList) {
                minInd = minTemp;
                if (maxInd < minInd) {
                    int temp = maxInd;
                    maxInd = minInd;
                    minInd = temp;
                }
                result = Math.min(Math.min(n - minInd, maxInd + 1), (minInd + 1) + (n - maxInd));
            }
        }


        System.out.println(result);
    }
}