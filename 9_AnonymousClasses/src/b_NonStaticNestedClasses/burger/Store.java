package b_NonStaticNestedClasses.burger;

public class Store {
    public static void main(String[] args) {
        Meal regularMeal = new Meal();
        System.out.println(regularMeal);

        System.out.println("-".repeat(30));
        System.out.println();
        Meal USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);
    }
}
