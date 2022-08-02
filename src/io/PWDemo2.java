package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {

        //创建文件流（低级流、字节流）：向文件中写入字节数据
        //如果希望对文件追加数据，需要在文件流打开追加模式 ,true
        FileOutputStream fos = new FileOutputStream("pw2.txt");
        //创建转换流（高级流、转换流）：衔接字节与字符流，负责将写出的字符转换成字节
        //明确字符集需要在转换流指定字符集
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //创建缓冲流（高级流、字符流）：块写文本数据加速
        BufferedWriter bw = new BufferedWriter(osw);
        //创建PrintWriter（高级流、字符流）：按行写出数据，自动行刷新
        PrintWriter pw  = new PrintWriter(bw,true);

        PrintWriter pw2 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pw2.txt",true),StandardCharsets.UTF_8)));

        /*
        实现简易记事本
        将控制台上输入的每一行字符串都按行写入文件
        如果在控制台单独输入exit，程序推出
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        String text;
        while(true){
            text=scanner.nextLine();
            //text.equals("exit"尽量不用
            //一定用字面量去比较变量，若自变量为null，用自变量去比较容易出现空指针异常
            if ("exit".equals(text)){
                break;
            }
            pw.println(text);
        }
            pw.close();
            System.out.println("程序结束");
    }
}
