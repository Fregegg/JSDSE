package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {

        File dir = new File("./demo");
        if (dir.exists()){
            dir.delete();
        }
        File dir1 = new File("./f");
        dir1.delete();

/*
        File dirs = new File("/e");
        if(dirs.exists()){
            dirs.delete();

 */

    }
}
