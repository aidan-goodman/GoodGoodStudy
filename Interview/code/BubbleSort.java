package quickhand;

import java.util.Arrays;

/**
 * Created by Aidan on 2021/10/8 13:54
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                int temp;
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
