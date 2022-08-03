package socket_1;

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
        try{
            serverSocket = new ServerSocket(8088);
            System.out.println("与客户端连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){

        try{
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line=br.readLine())!=null){
                System.out.println("客户端："+line);
                if ("exit".equals(line)){
                    System.out.println("已结束对话");
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server server =new Server();
        server.start();
    }
}
