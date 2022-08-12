package collection;

import java.util.ArrayList;
import java.util.List;
/**
 *  List提供了获取子集的操作:
 *  List subList(int start,int end)
 */
public class ListDemo3 {
    public static void main(String[] args) {
        //泛型只能写引用类型.对于基本类型而言要使用包装类

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //获取3-7

        System.out.println(list.subList(3, 8));
        //对子集的操作就是对原集合对应元素的操作
        List<Integer> subList = list.subList(3, 8);
        //将子集每个元素扩大10倍

        for (int i = 0; i < subList.size(); subList.set(i,10* subList.get(i++)));
        System.out.println(subList);
        System.out.println(list);
        //删除list集合中2-8
//        list.removeAll(subList);
//               ||
        subList.clear();
        System.out.println(list);

    }

}
