public class primeDetect {
    public static void main(String[] args) {
        int min_num=11;
        int max_num = 30;
        System.out.println("Number of prime numbers from "+ min_num+ "-" + max_num + ": " + countPrime(min_num, max_num));
    }

    public static int countPrime(int min_num, int max_num){
        int counter = 0;
        for (int num = min_num; num < max_num; num ++){
            System.out.println("Checking " + num);
            if (isPrime(num)){
                System.out.println(num + " is a prime number.");
                counter += 1;
            }
            // Stop at 20
            if (counter == 20){
                break;
            }
        }
        return counter;
    }

    public static boolean isPrime(int num){
        if (num <= 2){
            return (num==2);
        }

        for (int divisor = 2; divisor <  num / 2 + 1; divisor++){
            if (num % divisor == 0){
                return false;
            }
        }
        return true;
    }
}
