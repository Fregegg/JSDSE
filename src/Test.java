import java.io.File;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            File dir = new File("./a/"+i);
            dir.mkdirs();
        }
    }
}