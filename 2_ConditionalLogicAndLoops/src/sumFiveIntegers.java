import java.util.Scanner;

public class sumFiveIntegers {
    public static void main(String[] args) {
        int countNumbers = 1; int sumNumbers = 0;
        Scanner scanner = new Scanner(System.in);
        while (countNumbers < 6){
            System.out.println("Enter number #" + countNumbers + ":");
            String user_input = scanner.nextLine();
            try {
                int number = Integer.parseInt(user_input);
                sumNumbers += number;
            } catch (NumberFormatException e){
                System.out.println("That was an invalid number. Try again.");
                continue;
            }
            countNumbers ++;
        }
        System.out.println("The sum of your numbers are: " + sumNumbers);
    }
}
