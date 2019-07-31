package com.leakeyash;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Parent item = createParent();
        ((Child)item).print();
        System.out.println(324);
        System.out.println(324);
        System.out.println(324);
        System.out.println( "Hello World!" );

    }

    private static Parent createParent(){

        return new Child();
    }
}
