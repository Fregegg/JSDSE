package file;

import java.io.File;

/**
 * make
 * directory
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //    在当前目录下新建一个目录
        File dir = new File("./a/b/c/d/e/f");
        if (dir.exists()){
            System.out.println("已存在");
        }else{
            dir.mkdirs();
            System.out.println("已创建");
        }

    }
}
