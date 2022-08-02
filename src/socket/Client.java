package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    // Socket 封装了TCP/IP协议
    private Socket socket;//套接字
    public Client(){
        /*
            Socket实例化时需要传入两个参数
            1：服务器的地址信息 host （ip地址）
            2：服务器打开的服务端口 port(0~65535)
            客户端通过服务端的地址找到网络上的服务器计算机
            通过端口可以连接上该机器上运行的服务端应用程序。
         */

        try {
            System.out.println("正在连接服务端......");
            //localhost代表本机ip   实例化的过程就是连接的过程
            socket = new Socket("localhost",8088);
            System.out.println("与服务端建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        //客户端向服务端发送数据需要使用socket获取输出流
        try {
            OutputStream out = socket.getOutputStream();//向上造型
            PrintWriter pw = new PrintWriter
                    (new BufferedWriter
                            (new OutputStreamWriter
                                    (out, StandardCharsets.UTF_8)),true);
            pw.println("你好服务端！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
