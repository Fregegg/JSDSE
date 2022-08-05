package socket.socket_7;

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
            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了");

                Runnable handler = new ClientHandler(socket);
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

    private class ClientHandler implements Runnable {
        private String host;
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        public void run() {
            PrintWriter pw = null;
            try {

                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)), true);

                synchronized (Server.this) {
                    allOut = Arrays.copyOf(allOut, allOut.length + 1);
                    allOut[allOut.length - 1] = pw;
                }

                sendMessage(host + "上线了，当前在线人数：" + allOut.length);

                String line;

                while ((line = br.readLine()) != null) {
                    sendMessage(host + ": " + line);
                }

            } catch (IOException e) {
//                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (Server.this) {
                    for (int i = 0; i < allOut.length; i++) {
                        if (allOut[i] == pw) {
                            allOut[i] = allOut[allOut.length - 1];
                            allOut = Arrays.copyOf(allOut, allOut.length - 1);
                            break;
                        }
                    }
                }
                sendMessage(host + "下线了，当前在线人数：" + allOut.length);
            }
        }

        public void sendMessage(String message) {
            System.out.println(message);
            synchronized (Server.this) {
                for (PrintWriter printWriter : allOut) {
                    printWriter.println(message);
                }
            }
        }
    }
}
