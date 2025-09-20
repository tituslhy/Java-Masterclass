public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigitsAlt(1000));
        System.out.println(sumDigits(-1000));
        System.out.println(sumDigits(1));
    }
    public static int sumDigitsAlt(int num){
        //The instructor's solution
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

    public static int sumDigits(int num){
        // My solution
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
