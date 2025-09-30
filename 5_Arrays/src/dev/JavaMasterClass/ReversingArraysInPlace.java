package dev.JavaMasterClass;

import java.util.Arrays;

public class ReversingArraysInPlace {
    public static void main(String[] args) {
        int[] intArray = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(reverse(intArray)));
    }
    public static int[] reverse(int[] intArray){
        int[] copy = Arrays.copyOf(intArray, intArray.length);
        for (int i = 0; i < intArray.length; i++){
            copy[i] = intArray[intArray.length-1-i];
        }
        return copy;
    }
}
