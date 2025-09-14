public class JavaOperatorChallenge {
    public static void main(String[] args) {
        double varOne = 20.00d;
        double varTwo = 80.00d;
        double result = 100.00d * (varOne + varTwo);
        double remainder = result % 40.00d;
        boolean hasRemainder = remainder != 0.00;
        System.out.println(hasRemainder);
        if (hasRemainder == true){
            System.out.println("got some remainder");
        }
    }
}
