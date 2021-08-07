package 省赛真题.T2019;
/*
1,1,1,3,5,9....这样一串数列，求第20190324项的后四位
 */
public class 数列求值 {
    public static void main(String[] args) {
        int[] arr=new int[20190325];
        arr[1]=1;arr[2]=1;arr[3]=1;
        for (int i = 4; i < arr.length; i++) {
            arr[i]+=(arr[i-1]+arr[i-2]+arr[i-3]);
            arr[i]%=10000;
        }
        System.out.println(arr[20190324]);
    }
}
