package interfaceinheritance;

public class Hero {
    public static final String Signal = "Signal";
    public Hero(){
        System.out.println("Instantiated from Hero.");
    }
    public Hero(String name){
        System.out.println("Instantiated from Hero. Hero name: " + name);
    }
    public static void battleWin(){
        System.out.println("Hero win");
    }
    public void attack(){

    }
    public final int fullHP(){
        return 100;
    }
}
