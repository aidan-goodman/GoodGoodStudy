package 省赛真题.T2019;

/*
把2019分解成三个各不相同的整数之和，每个整数都不包含2或4
思路：
假设三个整数为 i，j，k 。
我们令 i < j < k 。
再枚举出 i & j ，
通过 k = 2019 - i - j 得出 k。
最终我们check 一下三个数字中是否含有 2 or 4.
如果符合条件即进行计数
 */
public class 数的分解 {
    static boolean check(int k){
        while (k>0) {
            if (k%10==2||k%10==4)
                return false;
            else
                k/=10;
        }
        return true;
    }
    public static void main(String[] args) {
        int sum=2019,ans=0;
        for (int i = 1; i < 1000; i++) {
            sum-=i;
            for (int j = i+1; j < 1500; j++) {
                sum-=j;
                if (sum>j&&check(i)&&check(j)&&check(sum))
                    ans++;
                sum+=j;
            }
            sum+=i;
        }
        System.out.println(ans);
    }
}
