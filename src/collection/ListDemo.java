package collection;

import java.util.*;

/**
 * java.util.List接口
 * List继承自Collection,是可以存放重复元素且有序的集合.
 * 特点:可以通过下标操作元素,使用更灵活.
 * List常用实现类:
 * java.util.ArrayList:内部使用数组实现,查询性能更好(随机访问)
 * java.util.LinkedList:内部使用链表实现,增删元素性能更好,首尾增删性能最佳.
 *
 * 在对集合操作的性能没有特别苛刻要求时,通常ArrayList是最好的选择.
 *
 */
public class ListDemo {
    public static void main(String[] args) {
//        我们在项目中一般是不会使用到 LinkedList 的，需要用到 LinkedList 的场景几乎都可以使用 ArrayList 来代替，
//        并且，性能通常会更好！
//        List<String> list = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("seven");
        System.out.println("list:"+list);
        /*
            List接口中提供了一套可以通过下标操作元素的方法

            E get(int index)
            获取指定下标对应的元素
         */
        String e = list.get(2);
        System.out.println(e);
        for (int i = 0; i < list.size(); i++) {
            e = list.get(i);
            System.out.println(e);
        }
        /*
            E set(int index,E e)
            将给定元素设置到指定位置，返回值为被替换的元素
         */
        String word = list.set(2,"six");
        System.out.println(word);
        System.out.println(list);
        System.out.println("_____");
        //集合反转交换
        //java.util.Collections是集合的工具类
        //api写法
        Collections.reverse(list);

        //内卷写法······效率也高
        for(int i=0;i<list.size()/2;list.set(i,list.set(list.size()-i-1,list.get(i++))));

        //普通写法
        for (int i = 0; i < list.size()/2; i++) {
            list.set(i,list.set(list.size()-1-i,list.get(i)));

        }
        System.out.println(list);

    }
}
