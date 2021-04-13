package 啊哈算法.meiju;

import java.util.Scanner;

public class 炸弹人 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int max=0;
        int p=0,q=0;
        char[][] arr=new char[n][m];
        for (int i = 0; i < n; i++) {
                String s=input.next();
                arr[i]=s.toCharArray();//字符数组输入
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]=='.'){//是空地
                    int sum=0;//每次判断都生成新的值和坐标
                    int x=i;
                    int y=j;
                    while (arr[x][y]!='#'){
                        if(arr[x][y]=='G')
                            sum++;
                        x--;//向上判断
                    }
                    x=i;y=j;
                    while (arr[x][y]!='#'){
                        if(arr[x][y]=='G')
                            sum++;
                        x++;//向下判断
                    }
                    x=i;y=j;
                    while (arr[x][y]!='#'){
                        if(arr[x][y]=='G')
                            sum++;
                        y--;//向左判断
                    }
                    x=i;y=j;
                    while (arr[x][y]!='#'){
                        if(arr[x][y]=='G')
                            sum++;
                        y++;//向右判断
                    }
                    if(sum>max){//如果当前炸死的敌人大于上次的
                        max=sum;
                        p=i;q=j;
                    }
                }
            }
        }
        System.out.println("("+p+","+q+")"+max);
    }
}
