package lambda;

import java.io.File;
import java.io.FileFilter;

/**
 * 用lambda表达式创建文件过滤器
 * 获取当前项目目录下名字中含有字母o的所有子项
 */
public class LambdaDemo2 {
    public static void main(String[] args) {


        File file =new File("./");
        File[] fs = file.listFiles(f->f.getName().contains("a") );
        for (File f : fs){
            System.out.println(f.getName());
        }


        /*3
        File file = new File(".");
        FileFilter filter = pathname -> pathname.getName().contains("m");
        File[] sub = file.listFiles(filter);
        for (File f:sub){
            System.out.println(f.getName());
        }

         */
/*2
        File file = new File(".");
        File[] sub = file.listFiles((f)->f.getName().contains("a"));
        for (File f : sub){
            System.out.println(f.getName());
        }

 */


/*1
        File file = new File(".");
        File[] sub = file.listFiles((f) -> f.getName().contains("o"));
        for (int i = 0; i < sub.length; i++) {
            System.out.println(sub[i].getName());
        }

 */



    }
}
