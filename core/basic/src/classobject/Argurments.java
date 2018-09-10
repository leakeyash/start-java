package classobject;
import variable.Converter;

public class Argurments {
    String name; //姓名

    float hp; //血量

    float armor; //护甲

    int moveSpeed; //移动速度

    public Argurments(){
        new Converter().Convert();
    }
    Converter converter;
    public Argurments(String name,float hp){
        this.name = name;
        this.hp = hp;
    }

    //复活
    public Argurments revive(Argurments h){
        h = new Argurments("提莫",383);
        return h;
    }

    public static void main(String[] args) {
        Argurments teemo =  new Argurments("提莫",383);

        //受到400伤害，挂了
        teemo.hp = teemo.hp - 400;

        Argurments ar = teemo.revive(teemo);
        System.out.println(teemo.hp);
        System.out.println(ar.hp);
        //问题： System.out.println(teemo.hp); 输出多少？ 怎么理解？

    }
}
