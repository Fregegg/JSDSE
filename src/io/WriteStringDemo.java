package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
/*
        FileOutputStream fos = new FileOutputStream("fo.txt");
        String line = "fofofo";
        byte[] data=line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);
        FileInputStream fis = new FileInputStream("fo.txt");
        System.out.println(fis.read());

 */



        /*
        //创建文件流时，若文件里有内容会将其清空
        FileOutputStream fos = new FileOutputStream("fos.txt");
        String line = " 两串字符~ ";
        //将当前字符串按照指定的字符集转换为一组字节。
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        FileOutputStream foss = new FileOutputStream("fos.txt",true);
        line = "\n另一串字符~";
        byte[] datas = line.getBytes(StandardCharsets.UTF_8);
        foss.write(datas);

        fos.close();

         */

//
//        FileOutputStream fos = new FileOutputStream("fo.txt");
//        String b = "你好";
//        byte[] line= b.getBytes(StandardCharsets.UTF_8);
//        fos.write(line);
//        fos.close();

        File file = new File("fo.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        fis.read(data,0,data.length);
        String tip = new String(data);
        System.out.println(tip);
        fis.close();


    }
}
