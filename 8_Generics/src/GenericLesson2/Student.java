package GenericLesson2;

import GenericLesson2.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    // These fields will create a lot of different students with different data
    // These fields are static because you don't want each instance to have this data
    // But be stored at the class level instead
    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String[] courses = {"C++", "Java", "Python"};

    public Student(){
        int lastNameIndex = random.nextInt(65, 91);
        name = firstNames[random.nextInt(5)] + " " + (char) lastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2018, 2023);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public String toString(){
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fname = fieldName.toUpperCase();
        return switch(fname){
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
