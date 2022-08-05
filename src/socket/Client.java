package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 使用readLine读取远端计算机发过来消息时，对应断开操作不同结果不同
 * 可能存在如下情况
 * 1:当远端计算机调用socket.close(),此时对方会进行正常的TCP四次挥手断开连接.
 * 那么readLine方法会返回值为null.
 * 2:readLine方法抛出异常：java.net.SocketException:connection reset
 * 说明客户端时非正常退出的（没有进行TCP挥手操作）
 */
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
            socket = new Socket("localhost",8088);
            System.out.println("与服务端建立连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Scanner scanner = new Scanner(System.in);
    public void start() {
        //启动读取服务端消息的线程
        ServerHandler serverHandler = new ServerHandler();
        Thread thread = new Thread(serverHandler);
        thread.setDaemon(true);
        thread.start();
        //客户端向服务端发送数据需要使用socket获取输出流
        try {
            OutputStream out = socket.getOutputStream();//向上造型
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8)), true);

            String line;
            while (true) {
                line = scanner.nextLine();
                if ("exit".equals(line)) {
                    socket.close();
                    break;
                }
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    private class ServerHandler implements Runnable{
        public void run(){
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

