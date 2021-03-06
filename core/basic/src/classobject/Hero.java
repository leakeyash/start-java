package classobject;

public class Hero {
    public String name; //实例属性，对象属性，非静态属性
    protected float hp;
    static String copyright;//类属性,静态属性

    {
        hp = 1f;
    }
    static {
        copyright = "cr";
    }
    public void die(){
        hp = 0;
    }

    //类方法，静态方法
    //通过类就可以直接调用
    public static void battleWin(){
        System.out.println("battle win");
        new Hero().die();
    }
    public static void main(String[] args) {
        Hero garen = new Hero();
        garen.name = "盖伦";

        Hero.copyright = "版权由Riot Games公司所有";
        System.out.println(garen.name);
        System.out.println(copyright);
        garen.copyright = "test";
        Hero teemo = new Hero();
        teemo.name = "提莫";
        System.out.println(teemo.name);
        System.out.println(teemo.copyright);

    }
}
