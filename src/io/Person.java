package io;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 测试对象序列化与反序列化
 *
 * Java Bean 定义规范  bean即class
 * 1.属性私有化
 * 2.为属性提供公开的GET SET方法
 * 3.定义无参构造器
 * 4.实现序列化接口
 *
 */
public class Person  implements Serializable {
    /*序列化运行时使用一个称为 serialVersionUID 的版本号与每个可序列化类相关联，
    该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。
    如果接收者加载的该对象的类的 serialVersionUID 与对应的发送者的类的版本号不同，
    则反序列化将会导致 InvalidClassException。
    强烈建议使用 private 修饰符显示声明 serialVersionUID（如果可能），
    原因是这种声明仅应用于直接声明类 -- serialVersionUID 字段作为继承成员没有用处。
    */
    private static final long serialVersionUID = 42L;
    private String name;
    private int age;
    private String gender;
    private String[] otherInfo;
    //transient 关键字 作用是忽略此属性，不序列化
    //private transient String[] otherInfo;



    public Person(){}

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }

}
