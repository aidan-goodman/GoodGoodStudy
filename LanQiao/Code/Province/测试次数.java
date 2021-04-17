package 省赛真题.T2018;

/*
x星球有很多高耸入云的高塔，刚好可以用来做耐摔测试。塔的每一层高度都是一样的，与地球上稍有不同的是，他们的第一层不是地面，而是相当于我们的2楼。
如果手机从第7层扔下去没摔坏，但第8层摔坏了，则手机耐摔指数=7。
特别地，如果手机从第1层扔下去就坏了，则耐摔指数=0。
如果到了塔的最高层第n层扔没摔坏，则耐摔指数=n
为了减少测试次数，从每个厂家抽样3部手机参加测试。
某次测试的塔高为1000层，如果我们总是采用最佳策略，在最坏的运气下最多需要测试多少次才能确定手机的耐摔指数呢？
 */
public class 测试次数 {//手机数与楼层数为固定值，最优策略为每种情况下运气差的值中的最小值（所有最大值中的最小值）
    static final int N = 1000;//设置常量层数
    static int[] f1 = new int[N + 1];
    static int[] f2 = new int[N + 1];
    static int[] f3 = new int[N + 1];

    public static void main(String[] args) {
        //当只有一部手机的情况
        for (int i = 1; i <= N; i++) {
            f1[i] = i;
        }
        //两部手机的情况
        for (int i = 1; i <= N; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) { //不能直接通过N进行计算，内循环一步步算上去
                int _max = 1 + Math.max(f2[i - j], f1[j - 1]);//选择每层进行测试时运气差的那一次
                ans = Math.min(ans, _max);//所有差运气中的最佳策略
            }
            f2[i] = ans;
        }
        //三部手机的情况
        for (int i = 1; i <= N; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                int _max = 1 + Math.max(f3[i - j], f2[j - 1]);
                ans = Math.min(ans, _max);
            }
            f3[i] = ans;
        }
        System.out.println(f3[N]);
    }
}
