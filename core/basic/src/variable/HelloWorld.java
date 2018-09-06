package variable;

/**
 * @author henry
 */
public class HelloWorld {
    public static void main(String[] args){
        byte b = 1;
        short s = 200;
        int i = 300;
        long l = 400;

        /*如果试图给byte类型的变量赋予超出其范围的值，就会产生编译错误*/
        //byte b2 = 200;

        char c ='中';
        //char 只能存放一个字符，超过一个字符就会产生编译错误
        //char c2 ='中国';
        //char c3 = 'ab';

        float f = Float.MIN_VALUE;
        System.out.print(f);
        //该行会出现编译错误，因为54.321是double型的
        //float f1 = 54.321;
        double d1 = 54.321;
        float f2 = 54.321f;

        boolean b1 = true;
        boolean b2 = false;

        // 虽然布尔型真正存放的数据是0(false) 1(true)
        // 但是，不能直接使用0 1 进行赋值
        //boolean b3 = 1;
    }
}
