package 算法入门;

import java.util.Scanner;

public class 报时助手 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        String[] s ={"zero","one","two","three","four","five","six","seven","eight",
                "nine","ten","eleven","twelve","thirteen","fourteen","fifteen",
                "sixteen","seventeen","eighteen","nineteen","twenty"};
        if(h<21){
            System.out.print(s[h]+" ");
        }else{
            System.out.print("twenty ");
            h = h-20;
            System.out.print(s[h]+" ");
        }
        if(m == 0){
            System.out.print("o'clock");
        }else if(m < 21){
            System.out.print(s[m]);
        }else if(m>20&&m<30){
            System.out.print("twenty ");
            m = m-20;
            System.out.print(s[m]);
        }else if(m==30){
            System.out.print("thirty");
        }else if(m>30&&m<40){
            System.out.print("thirty ");
            m = m-30;
            System.out.print(s[m]);
        }else if(m==40){
            System.out.print("forty");
        }else if(m>40&&m<50){
            System.out.print("forty ");
            m = m-40;
            System.out.print(s[m]);
        }else if(m==50){
            System.out.print("fifty");
        }else if(m>50&&m<60){
            System.out.print("fifty ");
            m = m-50;
            System.out.print(s[m]);
        }
    }
}