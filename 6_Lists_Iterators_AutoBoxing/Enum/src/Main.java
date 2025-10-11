import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DayOfTheWeek weekDay = DayOfTheWeek.SAT;
        System.out.println(weekDay);

        // There are only 2 methods for enums
        for (int i = 0; i < 10; i++){
            weekDay = getRandomDay();

            switchDayOfWeek(weekDay);

//            System.out.printf(
//                    "Iteration No %d: Name is %s, Ordinal Value = %d%n",
//                    i+1, weekDay.name(), weekDay.ordinal()
//            );
//            if (weekDay == DayOfTheWeek.FRI){
//                System.out.println("Found a Friday!!!");
//                break;
//            }
        }

    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay){
        int weekDayInteger = weekDay.ordinal() + 1;

        // You can switch using the enum type itself.
        switch (weekDay){
            case WED -> System.out.println("Found a wednesday! Wednesday is Day " + weekDayInteger);
            case SAT -> System.out.println("Found a saturday! Saturday is Day " + weekDayInteger);
            default -> System.out.println(
                    weekDay.name().charAt(0) + weekDay.name().substring(1).toLowerCase() + "day is Day " + weekDayInteger
            );
        }
    }

    public static DayOfTheWeek getRandomDay(){
        int randomInteger = new Random().nextInt(7);
        // Creates an array
        var allDays = DayOfTheWeek.values();
        return allDays[randomInteger];
    }
}
