package io_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("zhangsan.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        People p =(People) ois.readObject();
        System.out.println(p);
        ois.close();

    }
}
