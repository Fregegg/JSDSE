package enumDemo;

public class Demo1 {
    public enum Size{
        SMALL,MEDIUM,LARGE;
    }

    public static void main(String[] args) {
        Size size = Size.LARGE;
        System.out.println(size.toString());
        System.out.println(size.name());

        System.out.println(size==Size.LARGE);
        System.out.println(size.equals(Size.LARGE));
        System.out.println(size.ordinal());//2 从0开始，表示声明的顺序
        switch (size){
            case SMALL:
                System.out.println(1);
            case MEDIUM:
                System.out.println(2);
            case LARGE:
                System.out.println(3 );
        }

    }
}
