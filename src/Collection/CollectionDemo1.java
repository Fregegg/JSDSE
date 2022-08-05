package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        /*
            boolean add(E e)
            将给定元素添加到集合中，返回值表示是否成功
         */
        collection.add("one");
        collection.add("two");
        collection.add("three");
        System.out.println(collection);

        int size = collection.size();
        System.out.println(size);

        boolean isEmpty = collection.isEmpty();

        collection.clear();
    }
}
