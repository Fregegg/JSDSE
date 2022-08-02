package io;

import java.io.*;

/*
块读写：一次读写一组字节
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("./src/image.jpg");
        FileOutputStream fos = new FileOutputStream("image_cp.jpg");
        byte[] data = new byte[1024*10];
        int len;
        while((len=fis.read(data))!=-1){
            fos.write(data,0,len);
        }
        fis.close();
        fos.close();

        /*
        FileInputStream fis = new FileInputStream("./src/picture.jpg");
        FileOutputStream fos = new FileOutputStream("./pic_cp.jpg");
        byte[] data =new byte[1024*10];
        long start = System.currentTimeMillis();
        int len;
        while(( len = fis.read(data) )!=-1){
            fos.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end-start));
        fis.close();
        fos.close();


         */
    }

}
