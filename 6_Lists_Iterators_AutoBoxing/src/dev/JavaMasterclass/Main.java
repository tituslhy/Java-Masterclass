package dev.JavaMasterclass;

import java.util.ArrayList;
import java.util.Arrays;

/*
Remember records have their own default constructors
 */
record GroceryItem(String name, String type, int count){
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
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
        System.out.println(groceryList); //Default print statements are supported
    }
}
