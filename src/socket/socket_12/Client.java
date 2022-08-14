package socket.socket_12;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Freg
 * @date 2022/8/14 - 15:31
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost",8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start(){
        ServerHandler serverHandler = new ServerHandler();
        Thread thread = new Thread(serverHandler);
        thread.setDaemon(true);
        thread.start();
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8)),true);
            Scanner scanner = new Scanner(System.in);
            String line;
            while (true){
                line= scanner.nextLine();
                if ("exit".equals(line)){
                    socket.close();
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

        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),StandardCharsets.UTF_8));
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
