package io;
import java.io.*;
/*
缓冲流
 */
public class CopyDemo3 {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("image_cp.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis,1024*10);
        FileOutputStream fos = new FileOutputStream("image_cp_cp.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024*10);

        int d ;
        long start = System.currentTimeMillis();
        while((d=bis.read())!=-1){  //一次读取1byte，直到读取到10kb
            bos.write(d);//读取够10kb后才会写出一次
        }
        long end = System.currentTimeMillis();
        bis.close();bos.close();
        System.out.println(end-start);//63ms
    }
}
