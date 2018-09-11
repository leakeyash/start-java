package interfaceinheritance.intergrated;

public class Fish extends Animal implements Pet {
    public Fish(){
        super(0);
    }
    @Override
    public void eat() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void play() {

    }

    @Override
    public void walk(){
        System.out.println("I can't work.");
    }
}
