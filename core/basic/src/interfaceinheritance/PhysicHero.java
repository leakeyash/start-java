package interfaceinheritance;

public class PhysicHero extends Hero implements AttackDamage {
    final String str;
    private String name;
    private static String value;
    public PhysicHero(String name){
        this();
        System.out.println("I'm physic hero. Name"+ name);
    }
    public PhysicHero(){
        super("awesome");
        str = "test";
        System.out.println("I'm physic hero.");
    }
    public static void battleWin(){
        System.out.println("Physic hero win");
    }
    @Override
    public void physicAttack() {
        System.out.println("physic attack.");
    }
    @Override
    public void attack(){
        physicAttack();
    }
    @Override
    public void finalize(){
        System.out.println("I'm being collected.");
    }
//  can't override the final methods in parent class
//    public int fullHP(){
//
//    }

    class Score{
        public void legendary(){
            System.out.println(name+" legendary.");
        }
    }
    public static class EnemyCrystal{

        public void victory(){
            value = "test";
            System.out.println("vic");
        }
    }
}
