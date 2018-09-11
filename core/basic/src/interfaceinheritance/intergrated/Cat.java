package interfaceinheritance.intergrated;

public class Cat extends Animal implements Pet {
    private String name;
    public Cat(){
        super(4);
    }
    public Cat(String name){
        this();
        this.name = name;
    }
    @Override
    public void eat() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name+" playing.");
    }
}
