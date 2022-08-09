package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 聊天室服务端
 * <p>
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
//    private PrintWriter[] allOut = {};
    private final Collection<PrintWriter> allOut = new ArrayList<>();

    public Server() {
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

    public void start() {
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                //accept()为一个阻塞方法
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了");
                //启动一个线程负责处理该客户端交互
                Runnable handler = new ClientHandler(socket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程任务负责与指定客户端进行交互
     */
    private class ClientHandler implements Runnable {
        //记录当前对应客户端的IP地址
        private final String host;
        private final Socket socket;

        //通过socket获取远端计算机IP地址(获取到了客户端的)
        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        public void run() {
            PrintWriter pw = null;
            try {
                String line;
                //通过刚接受链接的socket获取输入流来读取该客户端发送来的消息
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                //输出流
                OutputStream os = socket.getOutputStream();
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8)), true);
                //上线：数组扩容
//                synchronized(Server.this){//加锁，预防线程安全问题
                    //不能用this,this在这里指向不同的对象，是不同的ClientHandler实例
                    //不能用allOut数组作为监视器对象，因为数组的扩容是创建新的长度+1的数组,对象是变化的
                    //将该输出流存入到共享数组allOut中
//                    allOut = Arrays.copyOf(allOut, allOut.length + 1);
//                    allOut[allOut.length - 1] = pw;
                    //如果是集合，可以用allOut
                synchronized(allOut){
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前在线人数：" + allOut.size());

                while ((line = br.readLine()) != null) {
                    sendMessage(host + ": " + line);
                }

            } catch (IOException e) {
//                e.printStackTrace();
            } finally {
                //处理客户端断开连接后的操作
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //客户端下线:将pw从allOut中删除
                synchronized (Server.this) {
                    /*
                    for (int i = 0; i < allOut.length; i++) {
                        if (allOut[i] == pw) {
                            allOut[i] = allOut[allOut.length - 1];
                            allOut = Arrays.copyOf(allOut, allOut.length - 1);
                            break;
                        }
                    }

                     */
                    allOut.remove(pw);

                }
                sendMessage(host + "下线了，当前在线人数：" + allOut.size());
            }
        }
        //将消息发送给所有客户端
        public void sendMessage(String message) {
            System.out.println(message);
            //将消息发送给客户端
            synchronized (allOut) {
                for (PrintWriter printWriter : allOut) {
                    printWriter.println(message);
                }
            }
        }
    }
}
