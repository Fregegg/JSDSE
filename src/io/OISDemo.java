package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("person.ojb");
        ObjectInputStream ois = new ObjectInputStream(fis);
        /*
        对象输入流提供了反序列化的方法 People readObject()
        该方法内部会通过对象输入流连接的流 先将字节读取过来，然后将这些字节
        还原为java对象返回，返回时统一以object形式返回。
         */
        //返回的类型不是Person类型而是Object类型
//        Object obj = ois.readObject();
//        Person person = (Person) obj;
        Person person = (Person)ois.readObject();
        System.out.println(person);
        ois.close();
    }
}
