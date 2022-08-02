package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OSWDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("TEXT.TXT");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        String line = "爱你孤身走暗巷，爱你不跪的模样";
        String line1="爱你和我那么像，缺口都一样";
        osw.write(line);
        osw.write(line1,0,line1.length());
        System.out.println(line1.length());
        osw.close();

    }
}
