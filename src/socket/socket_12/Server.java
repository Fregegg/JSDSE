package socket.socket_12;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Freg
 * @date 2022/8/14 - 15:31
 */
public class Server {
    private ServerSocket serverSocket;
    private Collection<PrintWriter> allOut = new ArrayList<>();

    public Server() {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        while(true){
            try {
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable{
        private String host;
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.host = socket.getInetAddress().getHostAddress();
            this.socket = socket;
        }

        @Override
        public void run(){
            PrintWriter pw = null;
            try {

                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
                BufferedReader br  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line= null;
                while((line=br.readLine())!=null){
                    sendMessage(host+": "+line);
                }
                synchronized (allOut) {
                    allOut.add(pw);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                synchronized (allOut) {
                    allOut.remove(pw);
                    sendMessage(host+"下线了，当前客户端人数："+allOut.size());
                }
            }
        }

        public void sendMessage(String message){
            System.out.println(message);
            synchronized (allOut) {
                for (PrintWriter printWriter : allOut) {
                    printWriter.println(message);
                }
            }
        }
    }
}
