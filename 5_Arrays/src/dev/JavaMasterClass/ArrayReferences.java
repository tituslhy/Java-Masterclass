package dev.JavaMasterClass;

import java.util.Arrays;

public class ArrayReferences {
    public static void main(String[] args) {
        int[] myIntArray = new int[5];
        int[] anotherArray = myIntArray; // anotherArray and myIntArray have the same 'address'

        // If you change one array, you also change the other because they have the same address
        anotherArray[0] = 1;
        System.out.println("Changing anotherArray: " + Arrays.toString(anotherArray));
        System.out.println("Changing anotherArray: " + Arrays.toString(myIntArray));
    }
}
