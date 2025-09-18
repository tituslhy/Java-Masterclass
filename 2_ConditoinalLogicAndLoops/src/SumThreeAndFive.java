public class SumThreeAndFive {
    public static void main(String[] args) {
        int counter = 0;
        int sums = 0;
        for (int num=1; num<1001; num++){
            System.out.println("Checking " + num);
            if (counter == 5){
                break;
            }
            if ((num % 3 ==0) && (num % 5 == 0)){
                counter +=1;
                sums += num;
                System.out.println(num + " is divisible by 5 and 3. Counter: "  + counter + ". Running sum: " + sums);
            }
        }
        System.out.println("Sum of first positive five numbers divisible by 3 and 5: " + sums);
    }
}
