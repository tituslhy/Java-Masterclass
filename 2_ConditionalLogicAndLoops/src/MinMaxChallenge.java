import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args) {
        double maxNum = Double.NEGATIVE_INFINITY;
        double minNum = Double.POSITIVE_INFINITY;
        Scanner scanner = new Scanner(System.in);
        boolean isValidNum = true;
        do {
            System.out.println("Enter any number: ");
            String user_input = scanner.nextLine();
            try{
                double number = Double.parseDouble(user_input);
                if (number > maxNum){
                    maxNum = number;
                }
                if (number < minNum){
                    minNum = number;
                }
            } catch(NumberFormatException e){
                isValidNum = false;
            }
        } while (isValidNum);
        System.out.println("The highest value you entered is: " + maxNum);
        System.out.println("The lowest vale you entered is: " + minNum);
    }
}
