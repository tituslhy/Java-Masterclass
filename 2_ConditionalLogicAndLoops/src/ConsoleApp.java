import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        int currentYear = 2025;

        try{
            System.out.println("Ah! You are " + getInputFromConsole(currentYear) + " years old.");
        } catch (NullPointerException e){
            System.out.println("Faced the exception " + e);
            System.out.println("Ah! You are " + getInputFromScanner(currentYear) + " years old.");
        }
    }
    public static int checkData(int currentYear, String dob){
        int minimumYear = currentYear - 125;
        int dobInt = Integer.parseInt(dob);
        if ((dobInt < minimumYear) || (dobInt > currentYear)){
            return -1;
        }
        return currentYear - dobInt;
    }
    public static int getInputFromConsole(int currentYear){
        //This function will only run when invoked in a terminal because IDEs disable the console;
        String dob = System.console().readLine("What is your date of birth");
        return currentYear - Integer.parseInt(dob);
    }
    public static int getInputFromScanner(int currentYear){
        //Common practice to name the class as a lower cased version of the class name
        boolean isValidAge = false;
        int age = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hi, what was your year of birth? ");
            age = checkData(currentYear, scanner.nextLine());
            isValidAge = age >= 0;
        } while (!isValidAge);
        return age;
    }
}
