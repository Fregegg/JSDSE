package thread;

public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Thread t1 = new Thread("范传奇") {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread("王克晶") {
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop {
    public void buy() {
        try {
            Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在挑选衣服...");
                Thread.sleep(5000);
            /*
            同步块使用时必须在synchronized（）中指定同步监视器对象
            该对象需满足两点：
            必须是引用类型的实例
            多个线程看到的必须是同一个对象
             */
            synchronized (this) {
                System.out.println(t.getName() + ":正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(t.getName() + ":结账离开");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}