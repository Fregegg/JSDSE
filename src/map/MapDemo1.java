package map;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map
 * Map体现的结构是一个多行两列的表格，第一列为Key，第二列为Value
 * 根据Key获取对应的value
 * Map中的Key不允许重复(equals判定)
 *
 * Map是一个接口
 * 常用实现类：
 * java.util.HashMap:散列表，哈希表
 * 散列表是当今查询速度最快的数据结构，被大量应用于缓存服务器中。
 */
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",88);
        map.put("数学",98);
        //put返回值是被替换的value
        //如果map的value是包装类，要用包装类接收，避免自动拆箱导致空指针
        Integer math = map.put("数学",82);
        System.out.println(math);
        map.put("英语",98);
        map.put("物理",18);
        map.put("化学",28);
        System.out.println(map);
        System.out.println(map.get("数学"));
        Integer value = map.remove("化学");
        System.out.println(map);
        System.out.println(value);

        boolean containmath = map.containsKey("数学");
        System.out.println(containmath);
        System.out.println(map.containsValue(28));
        map.clear();
        System.out.println(map);
    }
}
