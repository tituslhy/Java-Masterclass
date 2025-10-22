package b_NonStaticNestedClasses.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private List<Item> toppings;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;

        this.burger = new Burger("regular", "burger", this.price);
        this.burger.addToppings("sunny_side_egg", "onion_rings", "mayo", "lettuce", "tomatoes");

        drink = new Item("coke", "drink", 1.5);
        side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = price + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side,
                "Total Due: ", getTotal());
    }

    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }
    }

    private class Burger extends Item {
        private List<Item> toppings;

        public Burger(String name, String type, double price) {
            super(name, type, price);
            this.toppings = new ArrayList<Item>();
        }

        public Burger(){
            this("regular", "burger", Meal.this.price);
        }

        public void addToppings(String ... toppingNames){
            for (String toppingName: toppingNames){
                switch(toppingName.toLowerCase()){
                    case "onion_rings" -> toppings.add(new Item("onion rings", "toppings", 2));
                    case "sunny_side_egg" -> toppings.add(new Item("sunny side egg", "toppings", 1.5));
                    default -> toppings.add(new Item(toppingName, "toppings", 0));
                }
            }
        }

        @Override
        public String toString(){
            double burger_price = super.getPrice(price, conversionRate);

            String toppingPriceString = "";
            for (Item topping : toppings){
                double toppingPrice = topping.getPrice(topping.price, conversionRate);
                burger_price += toppingPrice;
                toppingPriceString += "%10s%15s $%.2f\n".formatted(topping.type, topping.name, toppingPrice);
            }
            String result = "-".repeat(30) + "BURGER" +"-".repeat(30) + "\n";
            result += "%10s%15s $%.2f\n".formatted(super.type, super.name, burger_price);
            result += toppingPriceString;
            result += "-".repeat(30) + "-".repeat(30);
            return result;
        }
    }

}
