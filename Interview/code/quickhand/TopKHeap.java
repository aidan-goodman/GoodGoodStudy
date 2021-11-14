package quickhand;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Aidan on 2021/10/8 13:27
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class TopKHeap {
    public static void main(String[] args) {
        int[] ans = findKthLargest(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findKthLargest(int[] nums, int k) {
        // 使用有 k 个元素的优先队列模拟最小堆
        Queue<Integer> minHeap = new PriorityQueue<>(k);
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
            System.out.println(minHeap);
        }

        for (int i = k; i < nums.length; i++) {
            if (minHeap.peek() != null) {
                int topEle = minHeap.peek();

                if (nums[i] > topEle) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }

        for (int i = 0; i < k; i++) {
            if (minHeap.peek() != null) {
                result[i] = minHeap.peek();
                minHeap.poll();
            }
        }
        return result;
    }
}
