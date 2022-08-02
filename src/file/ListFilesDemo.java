package file;
import java.io.File;
public class ListFilesDemo {
    public static void main(String[] args) {
        //获取当前目录下的所有子项
        File dir = new File(".");
        //boolean isFile()判断当前对象是否为文件
//        boolean isDirectory()判断当前对象是否为目录

        if (dir.isDirectory()){
            File[] subs = dir.listFiles();//列出
            System.out.println("当前目录下共有"+subs.length+"个子项");
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                System.out.println(sub);
            }
        }
        File[] files = dir.listFiles();
        for (File file : files){
            System.out.println(file.getName());
        }


    }
}
