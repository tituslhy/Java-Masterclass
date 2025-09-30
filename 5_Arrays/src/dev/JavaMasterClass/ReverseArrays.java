package dev.JavaMasterClass;

import java.util.Arrays;

/*
This is my solution to coding exercise 43
 */
public class ReverseArrays {
    private static void reverse(int[] intArray){
        int[] copy = Arrays.copyOf(intArray, intArray.length);
        System.out.println("Array = " + Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++){
            copy[i] = intArray[intArray.length-1-i];
        }
        System.out.println("Reversed array = " + Arrays.toString(copy));
    }
}
