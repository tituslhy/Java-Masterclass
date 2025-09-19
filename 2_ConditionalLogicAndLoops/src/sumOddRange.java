public class sumOddRange {
    public static void main(String[] args) {
        System.out.println(sumOdd(1, 100));
    }

    public static boolean isOdd(int number){
        if (number < 0){
            return false;
        }
        if (number % 2 == 0){
            return false;
        } else {
            return true;
        }
    }

    public static int sumOdd(int start, int end){
        if ((end<0) || (start<0) || (start > end)){
            return -1;
        }
        int runningSum = 0;
        for (int i = start; i <= end; i++){
            if (isOdd(i)){
                runningSum += i;
            }
        }
        return runningSum;
    }
}
