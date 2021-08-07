package 省赛真题.T2017;

public class 纸牌三角形 {
    static int[] a={1,2,3,4,5,6,7,8,9};
    static int ans=0;

    static void f(int k){
        if(k==9) {//K为9时为递归出口
            int x = a[0] + a[1] + a[3] + a[5];
            int y = a[0] + a[2] + a[4] + a[8];
            int z = a[5] + a[6] + a[7] + a[8];
            if (x == y && y == z) {
                ans++;
            }
        }
        //全排列代码
        for (int i = k; i < 9; i++) {
            int t=a[k];//将值进行替换
            a[k]=a[i];
            a[i]=t;
            f(k+1);//数组下标到9比较三边的值
            t=a[k];
            a[k]=a[i];
            a[i]=t;//将值换回来不影响下次循环的替换
        }
    }
    public static void main(String[] args) {
        f(0);
        System.out.println(ans/6);
    }
}
