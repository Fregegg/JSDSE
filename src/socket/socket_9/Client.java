package socket.socket_9;

import java.io.IOException;
import java.net.Socket;

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

    }

    private class ServerHandler implements Runnable{
        private String host;
        private Socket socket;

        public ServerHandler(){

        }

        public void run(){

        }


    }

}
