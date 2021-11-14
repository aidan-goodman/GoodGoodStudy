package test;

/**
 * Created by Aidan on 2021/9/11 20:50
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class SumBySub {
    public static void main(String[] args) {
        int[] result = subArraySum(new int[]{1, 2, 30, 4, 5, 6, 7, 8, 9, 10}, 10, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] subArraySum(int[] Array, int arrayLen, int subArrayLen) {
        // write code here
        int max = 0;
        int index = 0;
        int i = 0;
        while (i + subArrayLen < arrayLen) {
            int tempMax = 0;
            for (int j = i; j < i + subArrayLen; j++) {
                tempMax += Array[j];
            }
            if (max < tempMax) {
                max = tempMax;
                index = i;
            }
            i++;
        }
        return new int[]{index, max};
    }
}
