package variable;

/**
 * @author henry
 */
public class Scope {
    int i = 1;
    int j = i;  //其他的属性可以访问i
    public void method1(){
        System.out.println(i); //方法1里可以访问i
        System.out.println(k);
    }
    public void method2(){
        System.out.println(i); //方法2里可以访问i
    }
    int k = i;
}
