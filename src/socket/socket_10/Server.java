package socket.socket_10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Server {
    private final ServerSocket serverSocket;
    private final Collection<PrintWriter> allOut = new ArrayList<>();
    public Server(){
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void start(){
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
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
        PrintWriter pw=null;
        private final String host;
        private final Socket socket;
        public ClientHandler(Socket socket){
            host = socket.getInetAddress().getHostAddress();
            this.socket=socket;
        }

        public void sendMessage(String line ){
            System.out.println(line);
            for(PrintWriter pw : allOut){
                pw.println(line);
            }
        }

        @Override
        public void run() {
            try {
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));

                synchronized (Server.this) {
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前在线人数：" + allOut.size());

                String line;
                while((line=br.readLine())!=null){
                    sendMessage(host+": "+line);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                synchronized (Server.this) {
                    allOut.remove(pw);
                }
            }
            sendMessage(host + "下线了，当前在线人数：" + allOut.size());

        }
    }

}
