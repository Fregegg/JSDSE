package socket.socket_8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    private ServerSocket serverSocket;
    private PrintWriter[] allOut = {};

    public Server() {
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端已连接");
                ServerHandler handler = new ServerHandler(socket);
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

    private class ServerHandler implements Runnable {
        private String host;
        private Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        public void run() {
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8)),true);
                synchronized (Server.this) {
                    allOut = Arrays.copyOf(allOut,allOut.length+1);
                    allOut[allOut.length-1] = pw;
                }
                sendMessage(host+"上线了，当前人数： "+allOut.length);
                
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine()) != null) {
                    sendMessage(host + ": " + line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                synchronized (Server.this) {
                    for (int i = 0; i < allOut.length; i++) {
                        if (allOut[i]==pw){
                            allOut[i]=allOut[allOut.length-1];
                            allOut = Arrays.copyOf(allOut,allOut.length-1);
                            break;
                        }
                    }
                }
                sendMessage(host+"下线了，当前人数："+allOut.length);

            }
        }

        public void sendMessage(String message) {
            System.out.println(message);
            for (int i = 0; i < allOut.length ; i++) {
                allOut[i].println(message);
            }
        }
    }
}
