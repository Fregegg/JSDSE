package homework.day03;

import java.io.*;

/**
 * 将当前目录下的所有obj文件获取到，并进行
 * 反序列化后输出每个用户的信息(直接输出反序
 * 列化后的User对象即可)
 * @author Xiloer
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File dir = new File(".");
        File[] subs = dir.listFiles((f)->f.getName().endsWith(".obj"));
        for (int i = 0; i < subs.length; i++) {
            File sub = subs[i];
            FileInputStream fis = new FileInputStream(sub);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            if(obj instanceof User){
                User user = (User)obj;
                System.out.println(user);
            }
        }



    }
}













/*
    提示代码:
	需要用到的语句，尝试按照正确顺序将下列代码并放在main方法中完成需求，
	并在注释中标注每句话的作用，
	//【在这里标注该句代码意义】在当前目录
    File dir = new File(".");

    //【在这里标注该句代码意义】 遍历subs文件数组
    for(int i=0;i<subs.length;i++){

    }

    //【在这里标注该句代码意义】获取当前目录下名字以".obj"结尾的文件并将其赋给subs文件数组
    File[] subs = dir.listFiles((f)->f.getName().endsWith(".obj"));

    //【在这里标注该句代码意义】创建文件输入流fis输入sub
    FileInputStream fis = new FileInputStream(sub);

    //【在这里标注该句代码意义】将subs数组中的每一个obj文件赋给sub
    File sub = subs[i];//从数组中获取每一个obj文件

    //【在这里标注该句代码意义】输出user对象
    System.out.println(user);

    //【在这里标注该句代码意义】序列化对象ois
    ObjectInputStream ois = new ObjectInputStream(fis);

    //【在这里标注该句代码意义】将obj对象造型为User类型
    User user = (User)obj;

    //【在这里标注该句代码意义】 读出文件内容给obj对象
    Object obj = ois.readObject();

    //【在这里标注该句代码意义】判断obj是否是User类的对象
    if(obj instanceof User){

    }

 */