package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        //线程重写了toString方法
        System.out.println("主方法的线程是："+main);
        method();
    }
    public static void method(){
        Thread t = Thread.currentThread();
        System.out.println("method方法的线程是："+t);
    }
}
