public class palindromeDetect {
    // These are the functions for Chapter 6: Mastering Conditional Logic,
    // Loops, And Interactive Java Application
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(hasSharedDigit(-100, 500));
        System.out.println(hasSharedDigit(-1, 10));
        System.out.println(hasSameLastDigit(41,22,71));
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(isPerfectNumber(28));
        System.out.println(getDigitCount(789));
        System.out.println(canPack(1,0,4));
        System.out.println(getLargestPrime(12));
        System.out.println(getLargestPrime(12));
        printFactors(6);
        numberToWords(-121);
        printSquareStar(5);
        printSquareStar(8);
    }
    public static boolean isPalindrome(int number){
        if (number<0){
            number = number * -1;
        }
        String originalString = String.valueOf(number);
        String reversedString = "";
        for (int i = originalString.length() - 1; i >= 0; i--){
            reversedString += originalString.charAt(i);
        }
        return reversedString.equals(originalString);
    }
    public static int sumFirstAndLastDigit(int number){
        if (number<0){
            return -1;
        }
        String originalString = String.valueOf(number);
        int firstDigit = originalString.charAt(0) - '0';
        int lastDigit = originalString.charAt(originalString.length()-1) - '0';
        return firstDigit + lastDigit;
    }

    public static int getEvenDigitSum(int number){
        if (number<0){
            return -1;
        }
        int running_sum = 0;
        while (number > 0){
            int digit = number % 10;
            if (digit %2 == 0){
                running_sum += digit;
            }
            number = number / 10;
        }
        return running_sum;
    }

    public static boolean hasSharedDigit(int num1, int num2){
        if (num1<10 || num1 >99 || num2<10 || num2 >99){
            return false;
        }
        if (num1<0){
            num1 = num1 * -1;
        }
        if (num2<0){
            num2 = num2 * -1;
        }
        String originalString1 = String.valueOf(num1);
        String originalString2 = String.valueOf(num2);
        for (int i = 0; i < originalString1.length(); i++){
            if (originalString2.contains(
                    String.valueOf(originalString1.charAt(i))
                )
            ){
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(int num){
        return num >= 10 && num <= 1000;
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3){
       if (!isValid(num1) || !isValid(num2) || !isValid(num3)){
           return false;
       }

        String originalString1 = String.valueOf(num1);
        String originalString2 = String.valueOf(num2);
        String originalString3 = String.valueOf(num3);
        return originalString1.charAt(originalString1.length() - 1) == originalString2.charAt(originalString2.length() - 1) ||
                originalString1.charAt(originalString1.length() - 1) == originalString3.charAt(originalString3.length() - 1) ||
                originalString2.charAt(originalString2.length() - 1) == originalString3.charAt(originalString3.length() - 1);
    }

    public static void printFactors(int number){
        if (number < 1){
            System.out.print("Invalid Value");
        }
        for (int i = 1; i < number + 1; i++){
            if (number % i == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static int getGreatestCommonDivisor(int num1, int num2){
        if (num1<10 || num2<10){
            return -1;
        }
        int greatestDivisor = 0;

        for (int i = 1; i < Math.max(num1, num2) + 1; i++){
            if ((num1 % i == 0) && (num2 % i ==0)){
                greatestDivisor = i;
            }
        }
        return greatestDivisor;
    }

    public static boolean isPerfectNumber(int number){
        if (number < 1){
            return false;
        }
        int running_factor_sum = 0;
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                running_factor_sum += i;
            }
        }
        return running_factor_sum == number;
    }

    public static int reverse (int number){
        boolean isNegative = number < 0;
        String res = ""; String originalString = "";
        if (isNegative){
            originalString = String.valueOf(number * -1);
        } else {
            originalString = String.valueOf(number);
        }
        for (int i = originalString.length() - 1; i >-1; i--){
            res += originalString.charAt(i);
        }
        if (isNegative) {
            return -1*Integer.parseInt(res);
        }
        return Integer.parseInt(res);
    }

    public static int getDigitCount(int number){
        if (number < 0){
            return -1;
        }
        String originalString = String.valueOf(number);
        return originalString.length();
    }

    public static void numberToWords(int number){
        if (number <0){
            System.out.println("Invalid Value");
        }
        if (number == 0){
            System.out.print("Zero ");
        }
        else {
            int countDigits = getDigitCount(number);
            number = reverse(number);
            String originalString = String.valueOf(number);
            while (number > 0) {
                int remainder = number % 10;
                switch (remainder) {
                    case 0 -> System.out.print("Zero ");
                    case 1 -> System.out.print("One ");
                    case 2 -> System.out.print("Two ");
                    case 3 -> System.out.print("Three ");
                    case 4 -> System.out.print("Four ");
                    case 5 -> System.out.print("Five ");
                    case 6 -> System.out.print("Six ");
                    case 7 -> System.out.print("Seven ");
                    case 8 -> System.out.print("Eight ");
                    default -> System.out.print("Nine ");
                }
                number = number / 10;
            }
            if (originalString.length() != countDigits) {
                for (int i = 0; i < (countDigits - originalString.length()); i++) {
                    System.out.print("Zero ");
                }
            }
        }
    }

    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }
        int maxBigBags = goal/5;
        if (maxBigBags > bigCount){
            maxBigBags = bigCount;
        }
        int remainingGoal = goal - maxBigBags * 5;
        return remainingGoal <= smallCount;
    }

    public static int getLargestPrime(int number){
        if (number <= 1) {
            return -1;
        }

        int largestPrime = -1;

        // divide out factors starting from 2
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                largestPrime = i;
                number /= i;
            }
        }
        return largestPrime;
    }

    public static void printSquareStar(int num){
        if (num < 5){
            System.out.println("Invalid Value");
        }
        else {
            for (int row = 1; row <= num; row++){
                System.out.println();
                if ((row == 1) || (row ==  num)){
                    System.out.print("*".repeat(num));
                    continue;
                }
                for (int column = 1; column <= num; column ++){
                    if (
                        (column == 1) || (column == num) || (row == column) || (column == (num - row + 1))
                    ){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

            }
        }
    }
}
