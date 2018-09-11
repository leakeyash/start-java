package interfaceinheritance;

public class Simulator {
    public static void main(String[] args){
        Hero hero = new PhysicHero();
        hero.battleWin();
        PhysicHero ph = new PhysicHero();
        ph.battleWin();

        PhysicHero ph1 = new PhysicHero("new bee");
        ph1.new Score().legendary();
        // new PhysicHero.Score();
        new PhysicHero.EnemyCrystal().victory();
        ph1 = new PhysicHero("new bee2");

        System.gc();

        AttackDamage ad = () -> System.out.println("dynamic instance");
        ad.physicAttack();

        class ad2 extends Hero{
            @Override
            public void attack() {
                System.out.println("native class");
            }
        }
        new ad2().attack();

        final int number = 3;
        PhysicHero ph3 = new PhysicHero(){
            @Override
            public void attack() {
                int i =0;
                while(i<number){
                    super.attack();
                    i++;
                }
            }
        };
        ph3.attack();

        ad.hardAttack();
    }
}
