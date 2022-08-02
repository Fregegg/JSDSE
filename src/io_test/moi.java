package io_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class moi {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./src/io_test/women.txt"));
        Women person = (Women) ois.readObject();
        System.out.println(person);
        ois.close();
    }
}
