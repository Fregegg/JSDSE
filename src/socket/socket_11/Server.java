package socket.socket_11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class Server {
    private ServerSocket serverSocket;
    private Collection<PrintWriter> allOut = new ArrayList<>();

    public Server(){
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        while (true) {
            try {
                Socket socket  = serverSocket.accept();
                System.out.println("连接已建立");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }



    private class ClientHandler implements Runnable{
        private String host;
        private Socket socket;

        public ClientHandler(Socket socket){
            host = socket.getInetAddress().getHostAddress();
            this.socket=socket;
        }
        public void run(){
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine())!=null){
                    sendMessage(host + "说:" + line);
                }
                synchronized (allOut) {
                    allOut.add(pw);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                synchronized (allOut){
                    allOut.remove(pw);
                }
                sendMessage(host+"下线了,当前在线人数:"+allOut.size());

                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void sendMessage(String message){
            System.out.println(message);
            synchronized (allOut) {
                for (PrintWriter pw : allOut){
                    pw.println(message);
                }
            }
        }
    }


}
