package designpattern;

/**
 * 懒汉式单例模式的实现
 */
public class Singleton {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();//使用公共的静态方法创建对象
        Bank bank2 = Bank.getInstance();//对象为静态实际是同一个
        System.out.println(bank1 == bank2);//true
    }
}

class Bank {
    //1.使用私有构造器
    private Bank() {

    }

    //2.声明对象，不初始化
    //4.静态的getInstance要使用对象属性，所以也要设置为静态
    private static Bank bank = null;

    //3.使用公共方法返回对象（要想不创建对象调用只能设置为静态）
    public static Bank getInstance() {
//    public static synchronized Bank getInstance() {
//        synchronized (Bank.class) {同步方式一：需要每次线程判断，效率低
//        bank = new Bank();//不能直接使用（每次调用该方法都会创建一个静态对象）
//        if (bank == null) {
//            synchronized (Bank.class) {同步方式二：先判断再同步
        if (bank == null) {
            bank = new Bank();
        }
        return bank;
    }
}

