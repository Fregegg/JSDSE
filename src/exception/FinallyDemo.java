package exception;

public class FinallyDemo {
    public static void main(String[] args) {
//        try{
//            String str = "null";
//            System.out.println(str.length());
//            return;
//        }catch(NullPointerException e){
//            System.out.println("exception");
//        }finally{
//            System.out.println("finally");
//        }
//        System.out.println("end");
        s();
        System.out.println(2);
    }
    static void s(){
        int a;
        System.out.println(1);
        if (true){
            return;
        }
        System.out.println(3);
    }
}
