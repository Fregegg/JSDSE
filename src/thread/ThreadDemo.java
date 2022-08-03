package thread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        //线程的启动要调用start方法而不是调用run方法。
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread{
    //run不要主动调用
    public void run(){
        for (int i = 0; i < 1100; i++) {
            System.out.println("*****");
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        for (int i = 0; i < 1100; i++) {
            System.out.println("!!!!!");
        }
    }
}