package io_test;

import java.io.*;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        People people = new People();
        people.setAge(11);
        people.setGender("男");
        people.setName("张三");
        File file = new File("zhangsan.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.close();


    }

}
