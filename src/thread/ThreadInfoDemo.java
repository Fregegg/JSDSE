package thread;

/**
 * 获取县城相关信息的方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        //获取主线程
        Thread t=Thread.currentThread();
        //获取线程名称
        String name = t.getName();
        //获取唯一标识
        Long id = t.getId();
        //获取线程优先级 1-10 默认值5
        int priority = t.getPriority();
        //线程是否还活着
        boolean isAlive = t.isAlive();
        //是否为守护线程
        boolean isDaemon = t.isDaemon();
        //是否被中断了
        boolean isInterrupted = t.isInterrupted();

        System.out.println(name);
        System.out.println(id);
        System.out.println(t);
    }
}
