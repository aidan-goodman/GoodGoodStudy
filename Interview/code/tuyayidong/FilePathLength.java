package tuyayidong;

/**
 * Created by Aidan on 2021/9/3 16:22
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class FilePathLength {
    public static void main(String[] args) {
        String input = "Title\n\tSubtitle1\n\t\taaa\n\t\tSubsubtitle1\n\t\t\tbbbb\n\tSubtitle2\n\t\tSubsubtitle2\n\t\t\tcccccc";
        System.out.println(LongestPath(input));

    }

    public static int LongestPath(String input) {
        if (input.length() == 0) {
            return 0;
        }
        int[] sum = new int[input.length() + 1];    //从1开始，第0层就是0
        int Deepest = 0;
        int deepestLen = 0;

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf('\t') + 2;    // 计算当前在第几层（从第一层开始，没有\t为第一层）
            Deepest = Math.max(Deepest, level);
            deepestLen = s.length() - (Deepest - 1);    // 即便层数深度相同，最深长度也会更新
            int len = s.length() - (level - 1);     // 计算当前这一行的长度
            sum[level] = sum[level - 1] + len + 1;  //是目录，要+1，目录有个/的
        }
        return sum[Deepest - 1] + deepestLen;
    }
}
