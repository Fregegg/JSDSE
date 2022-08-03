package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    //ServerSocket总机
    private ServerSocket serverSocket;
    public Server(){
        try {
            System.out.println("正在启动服务端···");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            //accept()为一个阻塞方法
            while(true){
                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了");
                String line;
                //通过刚接受链接的socket获取输入流来读取该客户端发送来的消息
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader
                        (new InputStreamReader(is, StandardCharsets.UTF_8));

                while((line=br.readLine())!=null){
                    System.out.println("客户端说："+line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
