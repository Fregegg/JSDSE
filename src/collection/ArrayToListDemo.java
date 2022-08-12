package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * Arrays.asList()
 * 将数组转换为List集合（只能转换为List）
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String [] str = {"q","w","e"};
        //asList方法会返回Arrays定义的内部类ArrayList,
        // 该集合内部直接引用给定数组array
        List<String> list = Arrays.asList(str);
        System.out.println(list);
        //对集合的操作也是对原数组的操作
        //对原数组的操作也是对集合的操作
        //add和remove不行,list底层是数组，无法增加和删除，只能修改
        list.set(2,"r");
        str[0]="t";
        System.out.println(list);
        /*
            通过 创建新的List传参list可以实现对由数组转换而来的List的增加和删除
         */
        List<String> list2 = new ArrayList<>(list);//等同于先new再addAll();
        list2.add("增加元素");

    }
}
