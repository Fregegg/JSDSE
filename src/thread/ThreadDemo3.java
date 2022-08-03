package thread;

/**
 * 使用匿名内部类形式创建线程
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        /*
        Thread t1 = new Thread(){
                public void run(){
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("******");
                    } 
                }
        };
        
         */
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println("######");
//                }
//            }
//        };
//        Thread t2 =new Thread(r2);
        /*
        Thread t2 =new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("######");
            }
        });
        
         */
        
        Thread t1 = new Thread(){
          public void run(){
              for (int i = 0; i <1000 ; i++) {
                  System.out.println("!!!!!!");
              }
          }
        };
        
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("********");
            }
        });
        t1.start();
        t2.start();
        
        

    }
}
