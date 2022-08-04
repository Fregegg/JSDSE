package thread;

public class SyncDemo3 {
    public static void main(String[] args) {
        Test test = new Test();

        Thread t1 = new Thread(){
            public void run(){
                test.method();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                test.method();
            }
        };
        t1.start();
        t2.start();
    }
}
class Test {
    public synchronized static void method(){
        synchronized (Test.class){

        }
        Thread thread=Thread.currentThread();
        System.out.println("start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}