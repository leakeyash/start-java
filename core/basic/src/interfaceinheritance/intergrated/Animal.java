package interfaceinheritance.intergrated;

public abstract class Animal {
    protected int legs;
    protected Animal(int legs){
        this.legs = legs;
    }

    public void walk(){

    }

    public abstract void eat();
}
