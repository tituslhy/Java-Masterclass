package MethodReferenceChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        String[] results = new String[names.length];

        List<Function<String, String>> functions = new ArrayList<>(
                List.of(
                        String::toUpperCase,
                        Main::addMiddleInitial,
                        Main::addLastName
                )
        );
        for (int i = 0; i < names.length; i++){
            String result = names[i];
            for (var function: functions){
                result = result.transform(function);
            }
            results[i] = result;
        }

        List<String> toPrint = new ArrayList<>(List.of(results));
        toPrint.removeIf(Main::equalsLastName);
        toPrint.forEach(
                s -> System.out.println(sayHi(s))
        );
    }

    public static boolean equalsLastName(String s) {
        String[] parts = s.trim().split("\\s");
        return parts[0].equalsIgnoreCase(parts[2]);
    }

    public static String sayHi(String name){
        return "Hi " +  name;
    }

    public static String addLastName(String name){
        String firstName = name.split(" ")[0];
        return name + reverseString(firstName);
    }

    public static String addMiddleInitial(String name){
        return name.toUpperCase()  + " "+
                String.valueOf(getRandomChar()).toUpperCase() +". ";
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
