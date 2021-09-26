package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aidan on 2021/9/12 16:25
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class SubSets {

    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans=new ArrayList<>();
    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }


    public static List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            t.add(nums[i]);
        }

        return ans;
    }
}
