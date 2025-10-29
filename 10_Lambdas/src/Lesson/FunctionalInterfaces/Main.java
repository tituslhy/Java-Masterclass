package Lesson.FunctionalInterfaces;

public class Main {
    public static void main(String[] args) {

        // 'a+b' overrides the `operate` method in the functional interface
        int result = calculator((a, b) -> a + b, 5, 2);
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
