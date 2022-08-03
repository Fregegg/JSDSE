package socket.socket_4;

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
            serverSocket = new ServerSocket(8111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了!");
            Runnable runnable = new ClientHandler(socket);
            Thread thread = new Thread(runnable);
            thread.start();

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
            this.socket=socket;
            host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                String line;
                while (true){
                    if ((line = br.readLine())!=null){
                        System.out.println(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
