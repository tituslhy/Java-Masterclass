package JavaMasterClass.Animal;

public class Fish extends Animal{

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        // You can even leave this blank too. You don't have to actually implement
        // every abstract method

        if (speed.equals("slow")){
            System.out.println(getExplicitType()+ " lazily swimming");
        } else {
            System.out.println(getExplicitType() + " darting frantically");
        }
    }

    @Override
    public void makeNoise() {
        if (type.equals("Goldfish")){
            System.out.print("swish ");
        } else {
            System.out.print("splash ");
        }
    }
}
