package collection;

import java.util.*;
/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(114,22));
        list.add(new Point(311,453));
        list.add(new Point(534,6));
        list.add(new Point(723,811));
        list.add(new Point(923,10));
          /*
            Collections.sort(List list)
            该方法要求List集合中的元素必须是可比较的.判定是否课比较的标准为元素是否实现了接口:
            java.util.Comparable

            当我们使用一个API时,该API反过来要求我们为其修改代码,那么这个API就对我们的程序有侵入性.
            侵入性不利于程序后期维护,应当尽量避免.

            compare:比较
         */
//        Collections.sort(list);
        //单独定义比较器(定义Point元素的比较规则)
             /*
                compare方法用于定义o1和o2比较大小的规则,并用返回值表达大小关系.
                返回值实现的要求:
                如果返回值>0则表达的是o1>o2
                如果返回值<0则表达的是o1<o2
                如果返回值=0则表达的是o1=o2
             */
        Comparator<Point> c = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int olen1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int olen2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return olen1-olen2;//升序
//                return olen2-olen1; 降序
            }
        };
        Collections.sort(list,(o1, o2)->
                o1.getX()*o1.getX()+o1.getY()*o1.getY() -
                        o2.getX()*o2.getX()-o2.getY()*o2.getY()
        );
        System.out.println(list);
    }
}
