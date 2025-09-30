package dev.JavaMasterClass;

public class Varags {
    /*
    This uses the varargs method instead of String[] - an array of strings
     */
    public static void main(String... args) {
        String[] splitStrings = "Hello World".split(" ");
        printText(splitStrings);

        System.out.println("_".repeat(20));
        printText("Hello", "World", "again", "!");

        System.out.println("_".repeat(20));
        printText();

        String[] sArray = {"first", "second", "third", "fourth", "fifth"};
        System.out.println(String.join(",", sArray));
    }

    // THe variable argument ("...") must be the last argument in any function!
    private static void printText(String... textList){
        for (String t: textList){
            System.out.println(t);
        }
    }
}
