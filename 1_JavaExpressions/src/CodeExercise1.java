//Comprehensive 'Positive, Negative, Or Zero' Assessment In Java
//Write a method called checkNumber with an int parameter named number.
//
//
//
//The method should not return any value, and it needs to print out:
//
//        - "positive" if the parameter number is > 0
//
//        - "negative" if the parameter number is < 0
//
//        - "zero" if the parameter number is equal to 0
//
//
//
//NOTE:  The checkNumber method needs to be defined as public static like we have been doing so far in the course.
//
//NOTE:  Do not add a main method to your solution code!

public class CodeExercise1 {
    public static void checkNumber(int number){
        if (number > 0){
            System.out.println("positive");
        } else if (number < 0){
            System.out.println("negative");
        } else {
            System.out.println("zero.");
        }
    }
}
