package LambdaChallenge;

import Lesson.FunctionalInterfaces.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        Arrays.setAll(
                names,
                (i) -> {
                    names[i] = names[i].toUpperCase()  + " "+ String.valueOf(getRandomChar()).toUpperCase() +". " + reverseString(names[i]).toUpperCase();
                    System.out.println("-".repeat(25) + "ITERATION " + (i+1) + "-".repeat(25));
                    Arrays.asList(names).forEach(s -> System.out.println(s));
                    return names[i];
                }
        );
        System.out.println("-".repeat(50));
        System.out.println(Arrays.toString(names));

        System.out.println("-".repeat(50));
        List<String> nameList = new ArrayList<>(List.of(names));
        nameList.removeIf(
                s -> s.substring(0, s.indexOf(" ")).equals(
                        s.substring(s.lastIndexOf(" ") + 1)
                )
        );
        System.out.println(nameList);
    }

    public static boolean equalsLastName(String s){
        return s.split(" ")[0].equalsIgnoreCase(s.split(" ")[2]);
    }

    public static char getRandomChar(){
        var r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }

    public static String reverseString(String string){
        var reversedStringBuilder = new StringBuilder(string);
        reversedStringBuilder.reverse();
        return reversedStringBuilder.toString();
    }
}
