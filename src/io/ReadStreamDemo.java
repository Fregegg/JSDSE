package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadStreamDemo {

    public static void main(String[] args) throws IOException {
        File file  = new File("fos.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        fis.read(data);
        String line = new String(data,StandardCharsets.UTF_8);
        System.out.println(line);
        fis.close();

/*
        File file = new File("fos.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int)file.length()];
        fis.read(data);
        //将字节数组
        String line = new String(data,StandardCharsets.UTF_8);

        System.out.println(line);
        fis.close();

 */

    }
}
