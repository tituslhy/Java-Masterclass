public class whileLoopChallenge {
    public static void main(String[] args) {
        int num = 5;
        int end_num = 20;
        int even_number_counter = 0;
        int odd_number_counter = 0;

        while (num < end_num) {
            if (isEvenNumber(num)) {
                System.out.println(num);
                even_number_counter += 1;
            } else {
                odd_number_counter += 1;
            }
            if (even_number_counter == 5){
                break;
            }
            num += 1;
        }
        System.out.println("Number of odd numbers: " + odd_number_counter + " | Number of even numbers (capped at 5): " + even_number_counter);
    }
    public static boolean isEvenNumber(int num){
        return num % 2 == 0;
    }
}
