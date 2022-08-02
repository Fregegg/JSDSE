package exception;

import java.awt.*;
import java.io.IOException;

public class ThrowsDemo {
    public void dosome()throws IOException, AWTException{}
}

class SubClass extends ThrowsDemo{
    public void dosome(){
//    public void dosome()throws IOException, AWTException {}
        //重写时可以不再抛出任何异常
//    public void dosome(){}
        //重写时可以仅抛出部分异常
//    public void dosome()throws IOException{}
        //重写时可以抛出超类方法抛出异常的子类型异常
//    public void dosome()throws FileNotFoundException {}

        //不允许抛出额外异常(超类方法上没有声明的且也没有继承关系的异常)
//    public void dosome()throws SQLException {}
        //不允许抛出比超类方法声明的异常还大的异常
//    public void dosome()throws Exception {}
    }
}