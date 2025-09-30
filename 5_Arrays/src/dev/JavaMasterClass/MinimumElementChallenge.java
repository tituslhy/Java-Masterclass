package dev.JavaMasterClass;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {
    public static void main(String[] args) {
        int ans = findMin(readIntegers());
        System.out.println("The minimum is " + ans);
    }

    public static int[] readIntegers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a comma separated delimited list of numbers");
        String[] strArray = scanner.nextLine().split(",");
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static int findMin(int[] intArray){
        int[] copy = Arrays.copyOf(intArray, intArray.length);
        Arrays.sort(copy);
        return copy[0];
    }
}
