public class Main {
    public static void main(String[] args) {
        Item coke = new Item("drink", "coke", 1.50);
        coke.printItem();
        coke.setSize("LARGE");
        coke.printItem();

        Item avocado = new Item("Topping", "avocado", 1.50);
        avocado.printItem();

        Burger burger = new Burger("regular", 4.00);
        burger.addToppings("BACON","CHEESE", "MAYO");
        burger.printItem();

        //MealOrder regularMeal = new MealOrder();
        MealOrder regularMeal = new MealOrder("turkey", "7-up", "chili");
        regularMeal.addBurgerToppings("LETTUCE", "CHEESE", "MAYO");
        regularMeal.setDrinkSize("SMALL");
        regularMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("deluxe", "7-up", "chili");
        deluxeMeal.addBurgerToppings("AVOCADO", "BACON", "LETTUCE", "CHEESE", "MAYO");
        deluxeMeal.setDrinkSize("SMALL");
        deluxeMeal.printItemizedList();
    }
}
