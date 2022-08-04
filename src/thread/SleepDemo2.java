package thread;

public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            public void run(){
                System.out.println("睡觉中···");
                try {
                    Thread.sleep(1000000);
                    System.out.println("emmm");
                } catch (InterruptedException e) {
                    System.out.println("干嘛呐干嘛呐！");
                }
                System.out.println("醒了");
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("甘霖娘！");
            }
        };
        Thread huang = new Thread(){
            public void run(){
                System.out.println("小锤40大锤80");
                for (int i = 0; i < 5; i++) {
                    System.out.println("80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("搞定！");
                lin.interrupt();
            }
        };
        lin.start();
        huang.start();
        lin.interrupt();

    }
}
