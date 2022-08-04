package socket.socket_5;

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
            OutputStream os= socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
            PrintWriter pw = new PrintWriter(bw,true);

            Scanner scanner = new Scanner(System.in);
            while(true){
                String line= scanner.nextLine();
                if ("exit".equals(line)){
                    System.out.println("客户端已退出连接");
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
        Client client = new Client();
        client.start();
    }
}
