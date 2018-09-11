package interfaceinheritance;

public interface AttackDamage {
    String Damage = "Damage";
    void physicAttack();
    default void hardAttack(){
        System.out.println("hard attack.");
    }
}
