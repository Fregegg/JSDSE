package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BRDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("./src/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        /*
        String readLine()
        该方法可以读取一行字符串，并将内容返回（不含换行符）。
        （实际上第一次就读取了8k数据放入了缓冲区，但是只返回了第一行。
        再次调用时则返回第二行，知道8k数据返回完再从文件中读取数据）
        如果该行为空行（只有换行符），那么方法会返回一个空字符串
        如果流读取到了末尾则返回值为null。
         */
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();

/*
        BufferedReader br1 =new BufferedReader(new InputStreamReader(new FileInputStream("./src/io/BRDemo.java")));
        String line1;
        while((line1 = br1.readLine())!=null){
            System.out.println(line1);
        }
        br1.close();

 */

    }
}
