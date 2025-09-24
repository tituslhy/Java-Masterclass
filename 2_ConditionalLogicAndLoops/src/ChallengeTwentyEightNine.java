import java.util.Scanner;

public class ChallengeTwentyEightNine {
    public static void main(String[] args) {
        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));
        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(7.25, 4.3, 2.35));
        System.out.println(getBucketCount(3.4, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
        System.out.println(getBucketCount(3.26, 0.75));
//        inputThenPrintSumAndAverage();
    }
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets){
        if (
                (
                    (width <=0) || (height<=0) || (areaPerBucket<=0)
                ) || (
                extraBuckets < 0)
        ){
            return -1;
        }
        double area = width * height;
        int buckets = (int) (Math.ceil(area / areaPerBucket));
        return buckets - extraBuckets;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket){
        if ((width <=0) || (height<=0) || (areaPerBucket<=0)){
            return -1;
        }
        double area = width * height;
        return (int) (Math.ceil(area / areaPerBucket));
    }

    public static int getBucketCount(double area, double areaPerBucket){
        if ((area<=0) ||(areaPerBucket <=0)){
            return -1;
        }
        return (int) (Math.ceil(area / areaPerBucket));
    }

    public static void inputThenPrintSumAndAverage(){
        int count_num = 0;
        int running_sum = 0;
        long running_average = 0L;
        boolean isNumber = true;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Input a number: ");
            try{
                String entry = scanner.nextLine();
                int number = Integer.parseInt(entry);
                running_sum += number;
                count_num++;
                running_average = Math.round(running_sum/count_num);
            } catch(NumberFormatException e){
                isNumber = false;
                System.out.println("SUM = " + running_sum + " AVG = " + running_average);
            }
        } while (isNumber);
    }
}
