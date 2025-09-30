package dev.JavaMasterClass;

import java.util.Arrays;

public class MatrixRepresentation {
    public static void main(String[] args) {
        //Here's an example of how to define a 2D array. They don't have to have the same element counts
        int[][] array = {
                {1,2,3},
                {11,12,13,15,16},
                {21,22}
        };
        // Here's another way.
        int[][] secondArray = new int[3][3];

        int[][] nestedArray = new int[4][4];

        // Nested for loops - three ways
        for (int[] outer : nestedArray){
            System.out.println(Arrays.toString(outer));
        }

        for (int i = 0; i < nestedArray.length; i++){
            var innerArray = nestedArray[i]; //let Java infer the type
            for (int j = 0; j < innerArray.length; j++){
                System.out.print(nestedArray[i][j] + " ");
            }
            System.out.println();
        }

        for (var outer: nestedArray){
            for (var element: outer){
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Printing out a nested array to string in one line
        System.out.println();
        System.out.println(Arrays.deepToString(nestedArray));

        // Setting the value of the second element in the nestedArray
        nestedArray[1] = new int[] {10, 20, 30};
        System.out.println(Arrays.deepToString(nestedArray));

        Object[] anyArray = new Object[3];
        System.out.println(Arrays.toString(anyArray));

        anyArray[0] = new String[] {"a", "b", "c"};
        anyArray[1] = new String[][]{
                {"1", "2"},
                {"3", "4", "5"},
                {"6", "7", "8", "9"}
        };
        anyArray[2] = new int[2][2];
        System.out.println(Arrays.deepToString(anyArray));

        for (Object element : anyArray){
            System.out.println("Element type = " + element.getClass().getSimpleName());
            System.out.println("Element toString(): " + element);
            System.out.println(Arrays.deepToString(
                    (Object[]) element)
            );
        }
    }
}
