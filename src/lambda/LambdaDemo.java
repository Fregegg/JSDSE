package lambda;
import java.io.File;
import java.io.FileFilter;
public class LambdaDemo {
    public static void main(String[] args) {
        //该过滤器过滤名字中含有”t“的文件返回true
//        FileFilter filter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().contains("t");
//            }
//        };

        //使用lambda表达式表示
        FileFilter filter = (File pathname) -> {
            return pathname.getName().contains("t");
        };
        //参数类型可以不写
        FileFilter filter0 = (f) -> {
                return f.getName().contains("t");
        };
        //方法体只有一句代码时，可以不写大括号
        //方法体有return时，return也要删除
        FileFilter filter1 = (f) -> f.getName().contains("t");
        //参数列表中只有一个参数时，小括号可以不写
        FileFilter filter2 = (f) -> f.getName().contains("t");
        //一个参数可以省括号
        FileFilter filter3 = f -> f.getName().contains("t");


        File dir = new File("./src/file");
        File[] sub = dir.listFiles(f -> f.getName().contains("t"));
        for (File file : sub) {
            System.out.println(file.getName());
        }



    }

}
