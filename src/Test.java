
import java.util.Arrays;

abstract public class Test {

    public static void main(String[] args) {
        String[] s = new String[10];

        System.out.println(Arrays.toString(s));
        String q  = "hello";
        StringBuffer line =new StringBuffer("hello");
        System.out.println(line.length());
        String str = "we are students";
        System.out.println(str.indexOf("a"));
        String regex="/d{5,}";
        String l = "1566666";
        System.out.println(l.matches(regex));
    }
}