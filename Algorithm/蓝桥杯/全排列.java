package 算法入门;

public class 全排列 {
    public static void permutation(char[]ss,int i){
        if(ss==null||i<0 ||i>ss.length){//1
            return;
        }

        if(i==ss.length-1){//2
            System.out.println(new String(ss));
        }else{
            for(int j=i;j<ss.length;j++){//3
                char temp=ss[j];//交换前缀,使之产生下一个前缀
                ss[j]=ss[i];
                ss[i]=temp;
                permutation(ss,i+1);//4
                temp=ss[j]; //将前缀换回来,继续做上一个的前缀排列.//5
                ss[j]=ss[i];
                ss[i]=temp;
            }
        }
    }
    public static void main(String args[]){
        permutation(new char[]{'a','b','c','d'},0);
    }
}

