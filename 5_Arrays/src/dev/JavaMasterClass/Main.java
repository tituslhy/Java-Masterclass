package dev.JavaMasterClass;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[0] = 45;
        myIntArray[1] = 1;
        myIntArray[5] = 50; //Save 50 as element number

        double [] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        int[] firstTen = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("first = " + firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array = " + arrayLength);
        System.out.println("last = " + firstTen[arrayLength-1]);

        int [] newArray;
//        newArray = new int[] {5,4,3,2,1};
        newArray = new int[5];
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = newArray.length - i;
        }

        System.out.println();
        for (int num: newArray){
            if (num==newArray[newArray.length-1]){
                System.out.print(num);
            } else {
                System.out.print(num + ", ");
            }
        }

        // Printing arrays - do not use System.out.print(<array>);
        // Use this instead:
        System.out.println();
        String arrayElementsInAString = Arrays.toString(newArray);
        System.out.println(arrayElementsInAString);

        if(newArray instanceof int[]){
            System.out.println("newArray is an integer array");
        }

        // TO have an array of different types, create an object array
        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        objectArray[2] = newArray; //nested array
        System.out.println(Arrays.toString(objectArray));
    }
}
