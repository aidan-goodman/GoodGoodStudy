package 啊哈算法.search;

public class 类似纸牌 {
    static int[] a={1,2,3,4,5,6,7,8,9};
    static int[] book=new int[10];
    static int total=0;
    static void dfs(int k){
        if(a[0] *100+a[1]*10+a[2]+a[3] *100+a[4]*10+a[5]==a[6] *100+a[7]*10+a[8] ){
            total++;
        }
        for (int i = k; i < 9; i++) {
            int t=a[k];//将值进行替换
            a[k]=a[i];
            a[i]=t;
            dfs(k+1);//数组下标到9比较三边的值
            t=a[k];
            a[k]=a[i];
            a[i]=t;//将值换回来不影响下次循环的替换
        }
    }
    public static void main(String[] args) {
        dfs(0);
        System.out.println(total/2);
    }
}
