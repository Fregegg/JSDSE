package thread;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("!!!!!!");
                }
            }
        };
        Thread normal = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("######");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("^^^^^^");
                }
            }
        };
        min.setPriority(Thread.MIN_PRIORITY);
        normal.setPriority(Thread.NORM_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        normal.start();
        max.start();
    }
}
