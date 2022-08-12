package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  Map的三种遍历
 *  entrySet()  返回值是一对键值，用Set接收
 *  keySet()    返回值是Key，用Set接收
 *  values()    返回值是value，用Collection接收
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        //遍历所有的key
        //将Map中所有key以Set集合形式返回
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            System.out.println(s);
        }
        //Entry是一对键值对  Entry的泛型需要与map一致
        Set<Map.Entry<String,Integer>>entrySet = map.entrySet();
        for (Map.Entry<String, Integer> e : entrySet) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key+'\t'+value);
        }

        /*
            Collection values()
            将当前Map中所有的value以集合形式返回。
            为什么不是Map集合？因为可以有重复的value值
         */

        Collection<Integer> values = map.values();
        //新循环遍历
        for (Integer value : values) {
            System.out.println(value);
        }
        //forEach
        map.forEach((s, integer) -> System.out.println(s+integer));

    }
}
