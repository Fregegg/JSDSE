package socket.socket_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while(true){
                System.out.println("等待客户端连接···");
                Socket socket = serverSocket.accept();
                System.out.println("与客户端连接成功！");
                //启动一个线程负责处理该客户端交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    //线程任务，负责与指定客户端进行交互
    private class ClientHandler implements Runnable {
        //记录当前客户端的IP地址
        private String host;
        private Socket socket;
        public ClientHandler(Socket socket){
            this.socket = socket;
            //通过socket获取远端计算机IP地址
            host = socket.getInetAddress().getHostAddress();
        }

        public void run() {
            try {
                //socket是外部类的方法的局部变量，如何获得？
                //通过再内部类创建成员变量，利用构造器传参
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host+"说：" + line);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
