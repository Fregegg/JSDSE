package exception;

/**
 *Finally常见面试题
 *
 * final,finally,finalize的区别
 *
 * - final：类，方法，变量
 * - finally：finally异常处理机制
 * - finalize：是一个定义在Object中的方法，
 * 该方法为一个对象生命周期中的最后一个方法，
 * 当一个对象即将被GC回收前，调用该方法。
 * 若要重写该方法，要求不能有耗时的操作。
 */
public class FinallyDemo3 {
    public static int test(String str){
        try{
            return str.charAt(0)-'0';
        }catch(NullPointerException e){
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;
        }
    }
    public static void main(String[] args) {
        System.out.println(
                test("0")+","+test(null)+","+test("")
        );//3,3,3
    }
}
