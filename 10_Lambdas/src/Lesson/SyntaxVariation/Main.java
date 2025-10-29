package Lesson.SyntaxVariation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                List.of(
                        "alpha", "bravo", "charlie", "delta"
                )
        );

        for (String s: list){
            System.out.println(s);
        }

        System.out.println("-".repeat(50));
        //The way to use the Lambda Expression. Don't have to define the type because Java can infer the type
        //from the list type. Or just use `var`
        list.forEach((myString) -> System.out.println(myString));

        //You can also have lambda expressions point ot a code block
        System.out.println("-".repeat(50));
        String prefix="nato";
        list.forEach(
                (var myString) -> {
                    char first = myString.charAt(0);
                    System.out.println(prefix + " " + first + " means " + myString);
                }
        );
    }
}
