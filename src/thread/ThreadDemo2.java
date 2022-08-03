package thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyThread1 r1 = new MyThread1();
        MyThread2 r2 = new MyThread2();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();t2.start();
    }
}

class MyRunnable1 implements Runnable{
    public void run(){
        for (int i = 0; i < 1100; i++) {
            System.out.println("*****");
        }
    }
}

class MyRunnable2 implements Runnable{
    public void run(){
        for (int i = 0; i < 1100; i++) {
            System.out.println("!!!!!");
        }
    }
}
