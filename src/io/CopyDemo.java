package io;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("./src/picture.jpg");
        FileOutputStream fos = new FileOutputStream("./src/picture_cp.jpg");
        int d;
        while((d=fis.read())!=-1){
            fos.write(d);
        }



/*        FileInputStream fis = new FileInputStream("./src/image.jpg");
        FileOutputStream fos = new FileOutputStream("./src/img_cp.jpg");
        int d;
        long start = System.currentTimeMillis();
        while((d=fis.read())!=-1){
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("文件复制完毕，耗时"+(end-start)+"ms");
        System.out.println(start);
        System.out.println(Long.MAX_VALUE);

 */

    }
}
