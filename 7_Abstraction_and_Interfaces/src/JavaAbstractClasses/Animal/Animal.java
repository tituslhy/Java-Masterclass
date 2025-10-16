package JavaAbstractClasses.Animal;

/*
Notice that you cannot have private abstract methods because they must be extended.
 */
public abstract class Animal {
    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);

    public abstract void makeNoise();

    /*
    Adding 'final' prevents overriding for children class.
     */
    public final String getExplicitType(){
        return getClass().getSimpleName() + " (" + type + ")";
    }
}

/*
An abstract class extending another abstract class does not have to implement
the parent abstract class' methods! It can implement all, some or none of them,
and add new abstract methods
 */
abstract class Mammal extends Animal{
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed){
        System.out.print(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}