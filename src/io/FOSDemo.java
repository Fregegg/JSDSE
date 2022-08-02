package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo {

    public static void main(String[] args) throws IOException {
        //向当前项目目录中的文件fos.dat中写入字节数据。
        FileOutputStream fos = new FileOutputStream("./fos.dat");
        /*
        void write(int d )
        写出一个字节，写出的是给定的int值对应的2进制的“低八位”(最后八位)
        文件流实现了上述方法，作用是向文件中写入1个字节。

         */
        fos.write(1);
//        fos.dat中写入的是00000001
        fos.write(3);
//        现在fos.dat中是00000001 00000011
        fos.write(255);
        fos.write(256);
        fos.write(257);
        fos.write(-1);
        fos.close();//流使用完毕要关闭来释放资源


    }
}
