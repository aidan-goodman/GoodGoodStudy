package 算法入门;


public class 五次方数 {
    public static void main(String[] args) {
        for (int i = 10; i < 999999; i++) {
            int t1=i%10,t2=i/10%10,t3=i/100%10,t4=i/1000%10,t5=i/10000%10,t6=i/100000;
            if (Math.pow(t1,5)+ Math.pow(t2,5)+ Math.pow(t3,5)+ Math.pow(t4,5)+ Math.pow(t5,5)+ Math.pow(t6,5)==i)
                System.out.println(i);
        }
    }
}
