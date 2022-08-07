package socket.socket_9;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(){
        try {
            socket = new Socket("localhost",8088);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void start(){
        ServerHandler serverHandler = new ServerHandler(socket);
        Thread thread = new Thread(serverHandler);
        thread.setDaemon(true);
        thread.start();

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8)),true);
            String line = null;
            while(true){
                line=scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private class ServerHandler implements Runnable{
        private String host;
        private Socket socket;

        public ServerHandler(Socket socket ){
            host = socket.getInetAddress().getHostAddress();
            this.socket=socket;
        }

        public void run(){
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                String line ;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
