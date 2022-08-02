package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
缓冲输出流的缓冲区问题   缓冲区存在数据不能及时写出的问题
 */
public class BOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "天青色等烟雨";
        byte[] data=line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);//正常写出
        bos.write(data);//data不足缓冲区8kb的数据，所以没有写出
        /*
        void flush() 会将当前缓冲区中已经缓存的数据一次性写出
         */
//        bos.flush();//调用后可以直接写出缓冲区的数据
        bos.close();//close()调用了flush()
    }
}
