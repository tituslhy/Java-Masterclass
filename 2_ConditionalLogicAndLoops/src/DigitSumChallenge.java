public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigitsAlt(1000));
        System.out.println(sumDigits(-1000));
        System.out.println(sumDigits(1));
    }

    /**
     * The instructor's solution
     * The thinking is to use the '%' operator to keep taking the last
     * digit of the number out. Then add this to the running sum using
     * a while loop.
     */
    public static int sumDigitsAlt(int num){
        if (num<0){
            return -1;
        }
        int running_sum = 0;
        while (num > 9){
            running_sum += (num % 10);
            num = num / 10;
        }
        running_sum += num;
        return running_sum;
    }

    /**
     * My solution:
     * The thinking is to convert the digit to a string and then parse it
     * out character by character using a for loop
     */
    public static int sumDigits(int num){
        if (num<0){
            return -1;
        }
        String num_string = String.valueOf(num);
        int running_sum = 0;
        for (int i = 0; i < num_string.length(); i++){
            int num_ =  Integer.parseInt(
                    String.valueOf(
                            num_string.charAt(i)
                    )
            );
            running_sum += num_;
        }
        return running_sum;
    }
}
