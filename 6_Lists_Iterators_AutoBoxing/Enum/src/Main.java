import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.SAT;
        System.out.println(weekDay);

        // There are only 2 methods for enums
        for (int i = 0; i < 10; i++){
            weekDay = getRandomDay();
            System.out.printf(
                    "Iteration No %d: Name is %s, Ordinal Value = %d%n",
                    i+1, weekDay.name(), weekDay.ordinal()
            );
            if (weekDay == DayOfTheWeek.FRI){
                System.out.println("Found a Friday!!!");
                break;
            }
        }
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        // Creates an array
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }
}
