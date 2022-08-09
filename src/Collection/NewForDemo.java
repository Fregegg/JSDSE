package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * foreach 增强for循环(新循环)
 * foreach不支持在循环中添加删除操作，
 * 因为在使用foreach循环的时候数组（集合）就已经被锁定不能被修改，
 * 否则会报出java.util.ConcurrentModificationException异常
 * foreach适用于只是进行集合或数组遍历，for则在较复杂的循环中效率更高。
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"q","w","e"};
        for (String str : array) {
            System.out.println(str);
        }

        Collection c = new ArrayList();
        c.add("q");c.add("w");c.add("e");
        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            String str= it.next();
            System.out.println(str);
            System.out.println(it.next());
        }

        for (Object obj:c){
//            String str = (String)obj;
            System.out.println(obj);
        }

        Collection<String> s = new ArrayList<>();
        s.add("qq");
        s.add("ww");
        s.add("ee");
//        s.add(123);
        for (String str:s){
            System.out.println(str);
        }
    }
}
