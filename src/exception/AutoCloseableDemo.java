package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7 之后推出了一个新的特性：自动关闭特性
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        try(
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
            fos.write(1);
        }catch (IOException e){
            System.out.println("exception");
        }
    }
}
