package file;
import java.io.File;
import java.io.FileFilter;
/*
        重载的listFiles方法
        File[] listFiles(FileFilter filter)
        该方法允许我们传入一个文件过滤器，然后将当前File对象表示的目录中所有子项返回
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        File dir = new File("./src/file");
        if (dir.isDirectory()){
            //使用匿名内部类创建一个过滤器
            FileFilter filter = new FileFilter() {
                /*
                重写accept方法
                定义过滤器过滤file的条件，当参数file符合该过滤器的
                过滤条件时，方法返回true
                 */
                @Override
                public boolean accept(File pathname) {
                    String name = pathname.getName();
                    return name.contains("t");//返回含有t的文件
                }
            };
            //将过滤器 filter 带入方法
            File[] sub = dir.listFiles(filter);
            for (File file : sub) {
                System.out.println(file.getName());
            }
        }
        /*
        File dir = new File("./src/file");
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains("t");
            }
        }
        File[] sub = dir.listFiles(filter);
        for (File file : sub) {
                System.out.println(file.getName());
            }
        }
         */


        File ff = new File("./");

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains("s");
            }
        };

        File[] ffs = ff.listFiles(filter);
        for (File f:ffs){
            System.out.println(f.getName());
        }

        File[] fs = ff.listFiles((f)->f.getName().contains("e"));
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fs[i].getName());

        }



    }
}