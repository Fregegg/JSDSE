package socket.socket_10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Server {
    private ServerSocket serverSocket;
    private PrintWriter[] allOut={};
    public Server(){
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void start(){
        try {
            Socket socket = serverSocket.accept();
            ClientHandler handler = new ClientHandler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable{
        PrintWriter pw=null;
        private String host;
        private Socket socket;
        public ClientHandler(Socket socket){
            host = socket.getInetAddress().getHostAddress();
            this.socket=socket;
        }

        public void sendMessage(String line ){
            System.out.println(line);
            for (int i = 0; i < allOut.length; i++) {
                allOut[i].println(line);

            }
        }

        @Override
        public void run() {
            try {
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));

                synchronized (Server.this) {
                    allOut = Arrays.copyOf(allOut,allOut.length+1);
                    allOut[allOut.length-1]=pw;
                }

                String line;
                while((line=br.readLine())!=null){
                    sendMessage(host+": "+line);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                synchronized (Server.this) {
                    for (int i = 0; i < allOut.length; i++) {
                        if(allOut[i]==pw){
                            allOut[i]=allOut[allOut.length-1];
                            allOut = Arrays.copyOf(allOut,allOut.length-1);
                            break;
                        }
                    }
                }
            }
        }
    }

}
