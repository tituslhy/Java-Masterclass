package dev.JavaMasterClass;

import java.util.Arrays;
import java.util.Random;

/*
This class sorts a list of integers in descending order
 */
public class DescendingSortChallenge {
    public static void main(String[] args) {
        int[] intArray = getRandomArray(10);
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        int[] descArray = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++){
            descArray[i] = intArray[intArray.length -1 -i];
        }
        System.out.println(Arrays.toString(descArray));
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
