package dev.JavaMasterClass;

import java.util.Arrays;
import java.util.Scanner;

/*
This is the implementation for challenge 41 of the Java Masterclass
 */
public class SortedArray {
    public static int[] getIntegers(int array_size){
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[array_size];
        System.out.println("Enter " + array_size + " integer values:\r");
        for (int i = 0; i<intArray.length; i++){
            intArray[i] = Integer.parseInt(scanner.nextLine());
        }
        return intArray;
    }

    public static void printArray(int[] intArray){
        for (int i = 0; i < intArray.length; i++){
            System.out.println(
              "Element " + i + " contents " + intArray[i]
            );
        }
    }

    public static int[] sortIntegers(int[] intArray){
        Arrays.sort(intArray);
        int[] descArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++){
            descArray[i] = intArray[intArray.length -1 -i];
        }
        return descArray;
    }
}
