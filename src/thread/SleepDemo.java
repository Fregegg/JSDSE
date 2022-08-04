package thread;

import java.util.Scanner;

public class SleepDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number= scanner.nextInt();

        System.out.println("火箭发射倒计时");
        for (int i = number; i >=1; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        System.out.println("点火");
    }
}
