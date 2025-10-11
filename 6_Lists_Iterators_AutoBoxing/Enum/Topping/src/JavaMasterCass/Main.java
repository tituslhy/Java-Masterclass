package JavaMasterCass;

public class Main {
    public static void main(String[] args) {
        System.out.println("-".repeat(30));
        for (Topping topping: Topping.values()){
            System.out.println(topping.name() + " : $" + topping.getPrice());
        }
        System.out.println("-".repeat(30));
    }
}
