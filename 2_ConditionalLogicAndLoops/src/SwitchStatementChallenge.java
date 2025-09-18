public class SwitchStatementChallenge {
    public static void main(String[] args) {
        // Test cases for traditional switch expression
        natoAToE('A');
        natoAToE('B');
        natoAToE('C');
        natoAToE('D');
        natoAToE('E');

        // Enhanced test cases
        printDayOfWeek(0);
        printDayOfWeek(9);
    }

    public static void printDayOfWeek (int day){
        String dayOfWeek = switch (day){
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> day + " of the week does not exist.";
        };
        System.out.println(day +  " : " + dayOfWeek);
    }

    public static void natoAToE(char alphabet){
        switch (alphabet){
            case 'A':
                System.out.println("Able");
                break;
            case 'B':
                System.out.println("Baker");
                break;
            case 'C':
                System.out.println("Charlie");
                break;
            case 'D':
                System.out.println("Dog");
                break;
            case 'E':
                System.out.println("Easy");
                break;
            default:
                System.out.println(alphabet + " not recognized. only A-E are supported.");
        }
    }
}
