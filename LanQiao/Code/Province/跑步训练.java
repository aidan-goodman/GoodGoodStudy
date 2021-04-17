package 省赛真题.T2020;

public class 跑步训练 {
    public static void main(String[] args) {
        int sum=1000;
        boolean flag=true;//是否需要休息
        int count=0;
        while (sum>0){//其实循环一直进行，
            if (sum<600&&flag)
                break;//如果休息之后仍不能跑完一圈，跳出循环
            if (flag) {
                sum -= 600;
                flag=false;//需要休息
            }
            else if (!flag){
                sum+=300;
                flag=true;
            }
            count++;
        }
        System.out.println(count*60+sum/10);
        //跑一分钟消耗600，一秒钟即消耗六十
    }
}
