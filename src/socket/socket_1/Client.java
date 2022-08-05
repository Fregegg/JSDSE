package socket.socket_1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端连接成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Runnable handler = new ServerHandler();
        Thread thread = new Thread(handler);
        thread.setDaemon(true);
        thread.start();
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8)),true);
            Scanner scanner = new Scanner(System.in);
            while(true){
                String line = scanner.nextLine();
                if ("exit".equals(line)){
                    System.out.println("已退出连接");
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();

    }
    private class ServerHandler implements Runnable{

        public void run(){
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
                String line;
                while((line= br.readLine())!=null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
