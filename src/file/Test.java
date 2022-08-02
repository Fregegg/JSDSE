package file;

import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i <= 100; i++) {
            File test = new File("./Test"+i+".txt");
            test.createNewFile();
        }
        for (int i = 0; i <=100; i++) {
            File test = new File("./Test"+i+".txt");
            test.delete();
        }

    }
}
