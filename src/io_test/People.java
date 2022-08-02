package io_test;

import java.io.Serializable;
import java.util.Arrays;

public class People implements Serializable {
    private int age;
    private String name;
    private String gender;
    private String[] info;

    public People(){

    }

    public People(int age, String name, String gender, String[] info) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.info = info;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", info=" + Arrays.toString(info) +
                '}';
    }
}
