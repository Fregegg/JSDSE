package collection;


import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo4 {
    public static void main(String[] args) {

        Collection c1 = new ArrayList();

        //无序排列，add时有序，addAll后按特定算法排序
        //set不能包含重复的
//        Collection c1 = new HashSet();
        c1.add("java");
        c1.add(".net");
        System.out.println(c1);
        Collection c2 = new ArrayList();
        c2.add("android");
        c2.add("ios");
        System.out.println(c2);
        c1.addAll(c2);
        /*
        boolean addAll(Collection c)
        将给定的集合中所有元素添加到当前集合中，若集合发生了改变则返回true
         */
        System.out.println("c1"+c1);
        System.out.println("c2"+c2);
        Collection c3 = new ArrayList();
        c3.add("php");
        //cantainsAll(集合)，判断是否全部包含
        System.out.println(c2.containsAll(c3));

        //取交集
//        c1.retainAll(c2);
//        System.out.println("c1交集c2"+c1);
        //删交集
        c1.removeAll(c2);
        System.out.println(c1);


    }


}
