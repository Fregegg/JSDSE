package io_test;

import java.io.*;

public class Man implements Serializable {
    private int age;
    private String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class OOS{
//    public static void main(String[] args) throws IOException {
//        String name = "aaa";
//        int age = 1;
//        Man man = new Man(age,name);
//        File file = new File("./src/io_test/Man.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(man);
//        oos.close();
//
//    }
}
class OIS{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./src/io_test/Man.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Man m =(Man)ois.readObject();
        System.out.println(m);

    }
}
