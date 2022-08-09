package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("大");
        list.add("你好");
        list.add("早上好");
        list.add("集合");
        list.add("撒由那拉");
//        Collections.sort(list,(s1,s2)-> s1.length()-s2.length());
//        Collections.sort(list, Comparator.comparingInt(String::length));
        //JDK8之后，List集合提供了sort方法进行排序，sort方法依然需要传入比较器
        list.sort((s1,s2)-> s1.length()-s2.length());

        System.out.println(list);
    }
}
