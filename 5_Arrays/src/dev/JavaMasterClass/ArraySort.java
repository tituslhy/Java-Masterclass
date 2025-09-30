package dev.JavaMasterClass;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        String[] sArray = {"Abel", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        // Most Java classes come with binary search capabilities
        if (Arrays.binarySearch(sArray, "Mark") >=0){
            System.out.println("Found Mark in the list");
        } else {
            System.out.println("Mark was not found in the list");
        }
    }
}
