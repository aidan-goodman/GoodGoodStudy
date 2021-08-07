package 算法入门;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class 任意年月日 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year < 2007)//对2007年之前的数据不做处理
            return;
        int month = sc.nextInt();
        System.out.println("---------------------");//输出日历表头
        System.out.println(" Su Mo Tu We Th Fr Sa");
        System.out.println("---------------------");
        int week;//用来记录星期
        GregorianCalendar cal = new GregorianCalendar(year, month - 1, 1);//month要-1（后寻找原因）
        int totaldays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);//获取月份的总天数
        int startday = cal.get(Calendar.DAY_OF_WEEK) - 1;//获取第一天是星期几
        for (week = 0; week < startday; week++)
            System.out.print("   ");//输出开始星期前的空格
        for (int i = 1; i <= totaldays; i++) {
            if (i < 10)//判断是否为两位数然后输出不同的空格数
                System.out.print("  " + i);
            else
                System.out.print(" " + i);
            week++;//每输出一天，对应的星期+1
            if (i < totaldays) {//没有超过当前月总天数的情况下
                if (week == 7) {//判断是否过完一星期
                    System.out.println();//一星期之后换行
                    week = 0;//将星期设为周日，重新开始
                }
            } else
                System.out.println();//所有天数输完换行
        }
        System.out.println("---------------------");//输出下划线
    }
}
