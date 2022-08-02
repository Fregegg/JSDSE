package io;
import java.io.IOException;
import java.io.PrintWriter;
public class PWDemo {
    public static void main(String[] args) throws IOException {
        //PrintWriter提供了直接对文件做写操作的构造器
//       PrintWriter(File file)
//       PrintWriter(String pathname)
        PrintWriter pw = new PrintWriter("printwriter.txt");
        pw.println("战吗！战啊！");
        pw.println("以最卑微的梦");
        pw.close();

    }
}
