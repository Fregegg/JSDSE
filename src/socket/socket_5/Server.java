package socket.socket_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;
    public Server()  {
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("已连接");

                ClientHandler handler = new ClientHandler(socket);
                Thread t= new Thread(handler);
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

    private class ClientHandler implements Runnable{
        private String host;
        private Socket socket;
        public ClientHandler(Socket socket){
            host=socket.getInetAddress().getHostAddress();
            this.socket=socket;
        }
        public void run(){
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                while((line=br.readLine())!=null){
                    System.out.println(host+line);
                }
                System.out.println("已退出连接");

                System.out.println(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
