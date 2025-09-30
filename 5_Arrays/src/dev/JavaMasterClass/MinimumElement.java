package dev.JavaMasterClass;

import java.util.Arrays;
import java.util.Scanner;

/*
This is my solution to coding exercise 42
 */
public class MinimumElement {
    private static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    private static int[] readElements(int number){
        Scanner intScanner = new Scanner(System.in);
        int[] intArray = new int[number];
        for (int i = 0; i < number; i++){
            intArray[i] = Integer.parseInt(intScanner.nextLine());
        }
        return intArray;
    }
    private static int findMin(int[] intArray){
        int[] copy_ = Arrays.copyOf(intArray, intArray.length);
        Arrays.sort(copy_);
        return copy_[0];
    }
}
