package socket.socket_10;

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

    public void start(){
        ServerHandler serverHandler = new ServerHandler(socket);
        Thread thread = new Thread(serverHandler);
        thread.setDaemon(true);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
            while(true){
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    private class ServerHandler implements Runnable{
        private String host;
        public ServerHandler(Socket socket){
            host=socket.getInetAddress().getHostAddress();
        }
        public void run(){
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(host+": "+line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
