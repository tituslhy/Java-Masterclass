public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {
        int n1 = (int) (num1 * 1000);
        int n2 = (int) (num2 * 1000);
        System.out.println(n1 + " compared to " + n2);
        return n1 == n2;
    }

    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175)); // true
    }
}