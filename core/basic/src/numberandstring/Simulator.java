package numberandstring;


import java.awt.font.NumericShaper;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

/**
 * @author henry
 */
public class Simulator {
    public static void main(String[] args){
        Number number = new Number();
        number.convertToString();
        number.stringToInt();
        number.test();
        number.calNumber();
        number.calPrimeNumber();
        System.out.println(number.countPrimes(10));
        StringFormat sf = new StringFormat();
        sf.format();
        sf.prinfAndFormat();
        sf.newline();
        sf.localize();
        CharacterTest ct = new CharacterTest();
        ct.commonFunctions();
        ct.escaping();
        ct.test();
        randomString();
        new StringTest().test();
        stringCompare();

        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);

        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.delete(0,4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);
    }

    public static void randomString(){
        int count =0;
        char[] cs = new char[5];
        Random rd = new Random();
        while(count<5){
            int n = 0;
            while(!((n>=97&&n<=122)||(n>=65&&n<=90)||(n>=48&&n<=57))){
                n = rd.nextInt(122);
            }
            short s = (short)n;
            char c = (char)s;
            cs[count++] = c;
        }
        String str = new String(cs);
        System.out.println(str);
    }

    static void stringCompare(){
        String str1 = "the light";

        String str2 = new String(str1);

        //==用于判断是否是同一个字符串对象
        System.out.println( str1  ==  str2);
        String str3 = "the light";
        System.out.println( str1  ==  str3);
    }
}
