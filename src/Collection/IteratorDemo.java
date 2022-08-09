package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
    集合的遍历
 Iterator iterator()
 获取遍历当前集合元素的迭代器

 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("q");
        c.add("#");
        c.add("w");
        c.add("#");
        c.add("e");
        c.add("#");
        c.add("r");
        c.add("#");
        c.add("t");
        System.out.println(c);

        // 问——>取——>删
        Iterator it = c.iterator();//创建迭代器实例
        //hasNext 问是否有元素
        while(it.hasNext()){
            //.next()取元素，返回的是object类型
            String str = (String) it.next();
            //Object obj = it.next();
            //NoSuchElementException  问一次取了两次
            //System.out.println(obj);

            if ("#".equals(str)){
                //迭代器遍历的过程中不能通过集合方法增删元素，
                //否则会抛出并发修改异常ConcurrentModificationException
//                c.remove(str);
                //只能用迭代器自己的remove方法,没有add方法
                it.remove();
            }
            System.out.println(str);
        }
        System.out.println(c);
    }
}
