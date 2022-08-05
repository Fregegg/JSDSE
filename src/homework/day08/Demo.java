package homework.day08;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 局部变量在栈中
 * 对象在堆里
 * 属性在对象中(在堆里)
 *
 * 基本类型保存的值就是值本身
 * 引用类型保存的值是对象在堆里的地址
 *
 */
public class Demo {
    public static void main(String[] args) {
        String s = "hello";
        int a = 1;
        Point p = new Point(1,2);
        Collection c = new ArrayList();
        c.add(p);//{[1,2]}
        test(s,a,p,c);
        System.out.println("s:"+s);//? "helloworld"
        System.out.println("a:"+a);//? 2
        System.out.println("p:"+p);//?[7,5]
        System.out.println("c:"+c);//?{[7,5]}
    }
    public static void test(String s,int a,Point p,Collection c) {
        a++;//2
        s = s + "world";//helloworld
        p.setX(3);//(3,2)
        p = new Point(4,5);//(
        c.clear();
        c.add(p);//{[4,5]}
        c = new ArrayList();
        p.setX(7);//(7,5)
        c.add(p);
    }
}
