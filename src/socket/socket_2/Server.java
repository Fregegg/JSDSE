package socket.socket_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try{
            while(true){
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
    private class ClientHandler implements Runnable{
        private String host;
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        public void run(){
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while((line=br.readLine())!=null){
                    System.out.println(host+":"+line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

