package exception;

public class ThrowDemo{
    public static void main(String[] args) {
        Person p = new Person();
        try {
            p.setAge(1000);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
        System.out.println("此人年龄"+p.getAge());
    }

}
class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age<0||age>100){
            //主动实例化一个异常并使用throw将其抛出，由调用方处理
//            throw new RuntimeException("年龄不合法");
            throw new IllegalAgeException();
        }
        this.age = age;
    }
}