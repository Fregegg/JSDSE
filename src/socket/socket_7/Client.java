package socket.socket_7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 聊天室服务端
 *
 * 使用readLine读取远端计算机发过来消息时，对应断开操作不同结果不同
 * 可能存在如下情况
 * 1:当远端计算机调用socket.close(),此时对方会进行正常的TCP四次挥手断开连接.
 * 那么readLine方法会返回值为null.
 * 2:readLine方法抛出异常：java.net.SocketException:connection reset
 * 说明客户端时非正常退出的（没有进行TCP挥手操作）
 */
public class Server {
    /*
        运行在服务端的ServerSocket,主要作用两个:
        1:开启服务端口,客户端就是通过这个端口与服务端建立连接的.(ServerSocket构造方法)
        2:监听该端口,一旦一个客户端连接时,就会返回一个Socket实例与其通讯.(accept()方法的作用)
     */
    //ServerSocket总机
    private ServerSocket serverSocket;
    //保存所有客户端的输出流，用于广播消息
    private PrintWriter[] allOut={};

    public Server(){
        try {
            System.out.println("正在启动服务端···");
             /*
                如果执行下面代码出现异常:
                java.net.BindException:address already in use
                原因是申请的8088端口已经被系统其它程序占用了.
             */
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            //accept()为一个阻塞方法
            while(true){
                System.out.println("等待客户端连接");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了");
                //启动一个线程负责处理该客户端交互
                Runnable handler = new ClientHandler(socket);
                Thread t= new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        socket.Server server = new socket.Server();
        server.start();
    }
    /**
     * 该线程任务负责与指定客户端进行交互
     */
    private class ClientHandler implements Runnable{
        //记录当前对应客户端的IP地址
        private String host;
        private Socket socket;
        //通过socket获取远端计算机IP地址(获取到了客户端的)
        public ClientHandler(Socket socket){
            this.socket=socket;
            host = socket.getInetAddress().getHostAddress();
        }
        public void run(){
            PrintWriter pw = null;
            try {
                String line;
                //通过刚接受链接的socket获取输入流来读取该客户端发送来的消息
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                //输出流
                OutputStream os = socket.getOutputStream();
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os,StandardCharsets.UTF_8)),true);
                //将该输出流存入到共享数组allOut中
                allOut = Arrays.copyOf(allOut,allOut.length+1);
                allOut[allOut.length-1]=pw;
                System.out.println(host+"上线了，当前在线人数："+allOut.length);

                while((line=br.readLine())!=null){
                    System.out.println(host+"说："+line);
                    //将消息发送给所有客户端
                    for (int i = 0; i < allOut.length; i++) {
                        allOut[i].println(host+": "+line);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //处理客户端断开连接后的操作
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //将pw从allOut中删除
                for (int i = 0; i < allOut.length; i++) {
                    if (allOut[i]==pw){
                        allOut[i]=allOut[allOut.length-1];
                        allOut = Arrays.copyOf(allOut,allOut.length-1);
                        break;
                    }
                }
                System.out.println(host+"下线了，当前在线人数："+allOut.length);

            }
        }
    }
}

