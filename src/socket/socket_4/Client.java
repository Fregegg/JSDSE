package socket.socket_4;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;
    public Client(){
        try {
            socket = new Socket("localhost",8111);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8)),true);
            Scanner scanner = new Scanner(System.in);
            while(true){
                String line = scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Client client= new Client();
        client.start();
    }
}
