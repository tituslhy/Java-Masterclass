package JavaMasterClass.Animal;

public class Dog extends Mammal{

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        // You can even leave this blank too. You don't have to actually implement
        // every abstract method

        if (speed.equals("slow")){
            System.out.println(getExplicitType() + " walking");
        } else {
            System.out.println(getExplicitType() + " running");
        }
    }

    @Override
    public void makeNoise() {
        if (type.equals("Wolf")){
            System.out.print("Howling! ");
        } else {
            System.out.print("Woof! ");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " shed hair all the time");
    }
}
