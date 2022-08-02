package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        /*
        File file = new File("./Test.txt");
        //判断该位置下是否已经存在了这个文件或目录
        if (file.exists()){
            System.out.println("文件已存在");
        }else{
            file.createNewFile();
        }

         */
        /*
        File file = new File("./img");
        file.createNewFile();

         */
        File file  = new File("./test.java");
        file.createNewFile();








    }
}
