package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    // Socket 封装了TCP协议的通讯细节，使用它可以与远端计算机额建立TCP连接
//    并基于两个流与远端计算机进行双向通讯
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
            socket = new Socket("localhost",8011);
            System.out.println("与服务端建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Scanner scanner = new Scanner(System.in);
    public void start(){
        //客户端向服务端发送数据需要使用socket获取输出流
        try {
            OutputStream out = socket.getOutputStream();//向上造型
            PrintWriter pw = new PrintWriter
                    (new BufferedWriter
                            (new OutputStreamWriter
                                    (out, StandardCharsets.UTF_8)),true);
            String line;
            while(true){
                line = scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                /*
                Socket的close方法里封装了与服务端的4次挥手操作，与服务端断开连接
                并且该close还会在内部将通过socket获取的输入流和输出流关闭
                 */
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}

