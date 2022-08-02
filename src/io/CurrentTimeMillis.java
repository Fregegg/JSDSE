package io;

public class CurrentTimeMillis {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("文件复制完毕，耗时"+(end-start)+"ms");
        System.out.println(start);
        System.out.println(Long.MAX_VALUE);
    }
}
