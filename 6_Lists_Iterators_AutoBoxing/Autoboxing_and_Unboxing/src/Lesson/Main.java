package Lesson;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15);
        int unboxedInt = boxedInt;
        System.out.println("Unboxed Int: " + unboxedInt);

        //autoboxing
        Integer autoBoxed = 15;
        int autoUnboxed = autoBoxed;
        System.out.println(autoBoxed.getClass().getName());
        System.out.println("Auto-Unboxed Int: " + autoUnboxed);

        Double resultBoxed = getLiteralDoublePrimitive();
        double resultUnboxed = getDoubleObject(); //unboxing occurs automatically.

        Integer[] wrapperArray = new Integer[5]; //set to size of 5
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));

        Character[] characterArray = {'a','b','c','d'};
        System.out.println(Arrays.toString(characterArray));

        var ourList = getList(1,2,3,4,5);
        System.out.println(ourList);
    }

    /*
    varags means we can take in a variable number of integers
     */
    private static ArrayList<Integer> getList(int... varags){
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i: varags){
            aList.add(i);
        }
        return aList;
    }

    /*
    Returns an instance of the `Double` wrapper class
     */
    private static Double getDoubleObject(){
        return Double.valueOf(100.00);
    }

    /*
    Returns the primitive `double`
     */
    private static double getLiteralDoublePrimitive(){
        return 100.0;
    }

    private static int returnAnInt(Integer i){
        return i; //Java automatically unboxes
    }

    private static Integer returnAnInteger(int i){
        return i; //Java automatically boxes i into the Integer wrapper
    }
}
