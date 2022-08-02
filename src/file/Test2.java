package file;

import java.io.File;
import java.io.FileFilter;
/**
 * 获取./src/file中首字母为”D“的文件
 */
public class Test2 {
    public static void main(String[] args) {
        File dir = new File("./src/file");
        if (dir.isDirectory()){
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().startsWith("D");
                }
            };
            File[] sub = dir.listFiles(filter);
            for (File file : sub) {
                System.out.println(file.getName());
            }
        }
    }
}
