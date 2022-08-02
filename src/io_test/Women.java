package io_test;

import java.io.Serializable;

public class Women implements Serializable {
    private String name;
    private int age;

    public Women(){

    }
    public Women(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Women{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
