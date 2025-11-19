package Lesson._4;

import java.util.*;

public class Main {
    enum WeekDay{SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
    public static void main(String[] args) {
        List<WeekDay> annsWorkDays = new ArrayList<>(
                List.of(
                        WeekDay.MONDAY,
                        WeekDay.TUESDAY,
                        WeekDay.THURSDAY,
                        WeekDay.FRIDAY
                )
        );

        /// / Enum Set
        // instantiating from a copy
        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName()); //RegularEnumSet
        annsDaysSet.forEach(System.out::println);

        // instantiating use allOf
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(50));
        allDaysSet.forEach(System.out::println);

        // instantiating using complementOf
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaysSet);
        System.out.println("-".repeat(50));
        newPersonDays.forEach(System.out::println);

        // range
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
        System.out.println("-".repeat(50));
        businessDays.forEach(System.out::println);

        //// Enum Map
        Map<WeekDay, String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann", "Mary", "Bob"});
        employeeMap.put(WeekDay.MONDAY, new String[]{"Mary", "Bob"});
        employeeMap.forEach((k, v) -> System.out.println(
                k + ": " + Arrays.toString(v)));

    }
}
