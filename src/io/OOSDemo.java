package io;

import java.io.*;

/**
 * 对象流
 * java
 * 进行对象序列化与反序列化
 * java.io.ObjectOutputStream
 * 对象序列化由对象输出流完成：将一个java对象按照其结构转换成一组字节的过程
 * java.io.ObjectIntputStream
 * 对象反序列化由对象输入流完成：将一组字节还原为一个java对象的过程
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {




        /*
        //将一个Person对象写入person.obj文件中
        String name = "sakura";
        int age = 16;
        String gender = "女";
        String[] otherInfo = {"一", "二", "三"};
        Person person = new Person(name, age, gender, otherInfo);
        //文件输出流（低级流） 将字节写入指定文件
        FileOutputStream fos = new FileOutputStream("person.ojb");
        //对象输出流（高级流）将java对象进行序列化
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(person);
        System.out.println("写出完毕");
        oos.close();

         */
    }
}
