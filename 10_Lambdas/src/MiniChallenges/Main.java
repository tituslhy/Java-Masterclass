package MiniChallenges;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String sample = "Hello world!";

        // Challenge 1: Consumer Lambda
        Consumer <String> printWordsLambda = sentence -> {
          Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };
        printWordsLambda.accept(sample);

        //Challenge 2: Function Lambda
        Function<String, String> everySecondChar = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++){
                if (i%2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //Challenge 3: Using the functional lambda defined.
        String sample2 = "1234567890";
        System.out.println(everySecondChar.apply(sample2));

        //Challenge 4 and 5: Invoke functional lambda using a method
        System.out.println(
                functionInvoker(everySecondChar, sample2)
        );

        //Challenge 6: Supplier interface
        Supplier<String> iLoveJava = () -> "I love Java!";

        //Challenge 7 print string
        System.out.println(iLoveJava.get());

    }

    public static String functionInvoker(Function<String, String> function, String source){
        return function.apply(source);
    };
}
