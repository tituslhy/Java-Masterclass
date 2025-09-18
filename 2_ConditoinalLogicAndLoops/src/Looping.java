public class Looping {
    public static void main(String[] args) {
        for (double rate = 7.5; rate <= 10.0; rate += 0.25){
            double interest = calculateInterest(100, rate);
            if (interest >8.5){
                System.out.println("100 at " + rate + " interest = " + calculateInterest(100, rate));
                break;
            }
        }
    }

    public static double calculateInterest(double amount, double interestRate){
        return (amount * (interestRate / 100));
    }
}
