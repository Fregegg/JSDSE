package io_test;

import java.io.*;

public class mo {

    public static void main(String[] args) throws IOException {
        Women women = new Women();
        women.setAge(1);
        women.setName("qwe");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("./src/io_test/women.txt")));
        oos.writeObject(women);
        oos.close();
    }

}
