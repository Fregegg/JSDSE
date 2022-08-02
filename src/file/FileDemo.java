package file;


import java.io.File;

public class FileDemo {

    public static void main(String[] args) {

//        绝对路径无法实现一次编译到处运行
//        通常使用相对路径，有良好的跨平台性
        //相对路径
        File file = new File("./demo.txt");
        // "./"代表当前目录，在这里就是当前的项目目录


        String name = file.getName();
//        返回文件的大小（单位为字节）
        long len = file.length();

       boolean cw = file.canWrite();//文件是否可写
       boolean cr = file.canRead();//文件是否可读



    }
}
