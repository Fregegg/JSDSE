package io;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class ISRDemo {
    //读取时
    //读取当前源代码并输出到控制台
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./src/io/ISRDemo.java"));
        int d;
        while((d=isr.read())!=-1){
            char c =(char)d;
            System.out.print(c);
        }
        isr.close();
    }
}
