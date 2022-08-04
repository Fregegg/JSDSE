package socket.socket_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;

    public Server(){
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            System.out.println("等待客户端连接···");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("已连接");
                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable{
        private String host;
        private Socket socket;

        public ClientHandler(Socket socket){
            this.socket=socket;
            host = socket.getInetAddress().getHostAddress();
        }

        public void run(){
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                while(true){
                    line= br.readLine();
                    if (line==null){
                        System.out.println("客户端已退出连接");
                        socket.close();
                        break;
                    }
                    System.out.println(host+"： "+line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}
