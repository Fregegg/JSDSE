package Collection;

import java.util.ArrayList;
import java.util.List;
/**
 * List重载了一对add,remove方法
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");//Collection里定义的add方法
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        /*
          void add(int index,E e)
          将给定元素插入到指定下标
         */
        list.add(1,"one.five");
        System.out.println(list);
        /*
        E remove(int index);
        删除并返回指定位置的元素
         */

        String q = list.remove(2);
    }
}
