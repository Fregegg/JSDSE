package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("action");
        try{//try语句块不能单独写，后边必须跟catch或finally块
            String str = null;
            System.out.println(str.length());//JVM会实例化对应异常抛出
            String stt = "";
            System.out.println(stt.charAt(0));
//        }catch(NullPointerException e){//e接收到(捕获)这里出现的空指针异常
//            //针对该异常的解决办法
//            System.out.println("出现了空指针异常，并解决了");
//        }catch(StringIndexOutOfBoundsException e){
//            System.out.println("出现了字符串下标越界异常，并解决了");
        }//多个异常可以用同一种方法表示，写在一个catch里
        catch(NullPointerException|StringIndexOutOfBoundsException e){

        }
        System.out.println("end");
    }
}
