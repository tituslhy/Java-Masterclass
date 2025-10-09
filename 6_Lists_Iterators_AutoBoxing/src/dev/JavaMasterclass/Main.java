package dev.JavaMasterclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        //Retrieve from an array list
        System.out.println("Third item = " + groceries.get(2));

        //Check if a list contains something
        if (groceries.contains("mustard")){
            System.out.println("List contains mustard");
        }

        //Print index of an element
        System.out.println("first = " + groceries.indexOf("yoghurt"));
        System.out.println("last = " + groceries.lastIndexOf("yoghurt"));

        //Selective element removal
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yoghurt");
        System.out.println(groceries);
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        // Retain items
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        // Delete all items
        groceries.clear();
        System.out.println("isEmpty = "+ groceries.isEmpty());

        //Populating the array list
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        //Sort
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder()); //strings will be ordered alphabetically
        System.out.println(groceries);
        groceries.sort(Comparator.reverseOrder()); //strings will be ordered alphabetically in reverse

        // Defining an array that has the same size and type of the list.
        var groceryArr = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArr));

        String[] originalArray = new String[] {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray); //var doesn't require us to declare the type - inferred at run time.
        originalList.set(0, "One");
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray)); //the array has been changed as well!

        originalList.sort(Comparator.naturalOrder());
        System.out.println("list: " + originalList);
        System.out.println("array: " + Arrays.toString(originalArray)); //the array has been changed as well!

        // This creates a fixed size list
        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList);
    }
}
