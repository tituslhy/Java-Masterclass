package dev.JavaMasterClass;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtilities {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        System.out.println(Arrays.toString(firstArray));

        // Sort
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        // Change all elements in an array to the same value
        int[] secondArray = new int[10];
        System.out.println(Arrays.toString(secondArray)); //default is zeroes
        Arrays.fill(secondArray, 5); //changes all values to 5
        System.out.println(Arrays.toString(secondArray));

        // Creating a copy of the original array
        int[] thirdArray = getRandomArray(10);
        System.out.println(Arrays.toString(thirdArray));

        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(fourthArray));

        // Notice that sorting the copied array do not impact the original array;
        Arrays.sort(fourthArray);
        System.out.println(Arrays.toString(thirdArray));
        System.out.println(Arrays.toString(fourthArray));

        // When copying an array less than the length of the original array, we take only the first n numbers
        int[] smallerCopy = Arrays.copyOf(thirdArray, 5);
        System.out.println(Arrays.toString(smallerCopy));

        // If more than the length of the original array, the rest are set to zeroes.
        int[] largerCopy = Arrays.copyOf(thirdArray, 15);
        System.out.println(Arrays.toString(largerCopy));

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};
        if (Arrays.equals(s1, s2)){
            System.out.println("Arrays are equal");
        } else {
            System.out.println("Arrays are not equal");
        }

    }

    public static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i < len; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
