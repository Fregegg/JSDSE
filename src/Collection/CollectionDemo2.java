package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,10));
        System.out.println(c);
        Point p = new Point(1,2);

        //Point类未重写equals方法时，为false
        //重写equals方法后为true，说明contains比较取决于equals方法
        System.out.println(c.contains(p));
        //remove也依赖于equals方法，重写了才能比较内容
        //删去和对象p相同的内容，注意：仅删一次，即若有重复的，删第一个
        c.remove(p);




    }
}
