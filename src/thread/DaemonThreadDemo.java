package thread;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for (int i = 0; i < 5; i++) {
                    System.out.println("let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("噗通");
            }
        };
        Thread jack = new Thread(){
            public void run(){
                while(true){
                    System.out.println(" u jump , I jump");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        rose.start();
        jack.setDaemon(true);
        jack.start();
    }
}
