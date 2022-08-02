package io;

import java.io.*;

public class FISDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("TEST.TXT");
        file.createNewFile();
        FileInputStream fis = new FileInputStream(file);
        System.out.println(fis.read());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(1);
        System.out.println(fis.read());
        fos.write(2);
        System.out.println(fis.read());
        fis.close();
        fos.close();





        /*
//        将当前项目目录下的fos.dat文件读取
        FileInputStream fis = new FileInputStream("fos.dat");

//        第一次调用读取第一次输入的，
        int d = fis.read();
        System.out.println(d);//1
//        第二次调用读取第二次输入的，
        d= fis.read();//3
        System.out.println(d);//3
        d= fis.read();//255
        System.out.println(d);//255
        d=fis.read();//256
        System.out.println(d);//0
        d=fis.read();//257
        System.out.println(d);//1
        d=fis.read();//-1
        System.out.println(d);//255
//        内容读取后，当没有内容可以读取时返回-1
        d=fis.read();//无内容
        System.out.println(d);//-1
        fis.close();

         */




    }

}
