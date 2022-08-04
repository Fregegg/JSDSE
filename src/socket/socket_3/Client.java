package socket.socket_3;

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
            e.printStackTrace();
        }

    }

    public void start(){
        try {
            Scanner scanner = new Scanner(System.in);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8)),true);
            while(true){
                String line = scanner.nextLine();
                if ("exit".equals(line)){
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
}
