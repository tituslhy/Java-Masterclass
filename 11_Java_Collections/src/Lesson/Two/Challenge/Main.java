package Lesson.Two.Challenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All tasks", tasks);

        //This comparator works because high, medium and low are indexes 0, 1, and 2
        //in the Priority enum
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks", annsTasks, sortByPriority);
    }
    private static void sortAndPrint(String header, Collection<Task> collection){
        sortAndPrint(header, collection, null);
    }
    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter){
        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }
}
