package Lesson.FunctionalInterfaces;

public class Main {
    public static void main(String[] args) {

        // 'a+b' overrides the `operate` method in the functional interface
        // You don't have to specify the type here! Java infers
        int result = calculator((a, b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator(
                (a, b) -> a.toUpperCase() + " " + b.toUpperCase(),
                "Ralph",
                "Kramden"
        );
        // This is how to use `return` statements in lambda expressions
        var result4 = calculator(
                (a, b) -> {
                    var c = a+b;
                    return c;
                },
                5,
                2);
    }

    /*
    Operation<T> function should be a lambda expression or a function return
     */
    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
