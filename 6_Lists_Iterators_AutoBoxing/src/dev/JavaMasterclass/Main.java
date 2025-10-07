package dev.JavaMasterclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Remember records have their own default constructors
 */
record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);
        System.out.println(Arrays.toString(groceryArray));

        // This way of using array lists is not advised because you ed up with a lot of different types
        // in the array list.
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yoghurt");

        //Use it this way instead. ArrayLists are resizeable
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Yoghurt"));
        groceryList.add(0, new GroceryItem("Milk")); //overloaded add method takes in an index to insert
        groceryList.set(0, new GroceryItem("Apples")); //overloaded add method takes in an index to insert
        System.out.println(groceryList); //Default print statements are supported
        groceryList.remove(1);
        System.out.println(groceryList);

        String[] items = {"apples", "bananas", "milk", "eggs"};
        List<String> list = List.of(items); //factorymethod. Note that this is not an arrayList
        System.out.println(list);
        System.out.println(list.getClass().getName()); //Immutable nested class. Cannot add/remove/reorder.

        // Creating a new mutable list from an immutable list
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yoghurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles","mustard","cheese")
        );
        System.out.println(nextList);

        //Add lists
        groceries.addAll(nextList);
        System.out.println(groceries);
    }
}
