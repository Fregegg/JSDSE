package socket.socket_3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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
            this.host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                while((line = br.readLine())!=null){
                    System.out.println(host+":"+line);
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

