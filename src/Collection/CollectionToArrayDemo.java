package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * 集合转换为数组
 * toArray()
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        //Object[] array = c.toArray();
        String[] array = list.toArray(new String[list.size()]);
                System.out.println(Arrays.toString(array));
    }
}
