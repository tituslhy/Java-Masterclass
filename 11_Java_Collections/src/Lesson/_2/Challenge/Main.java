package Lesson._2.Challenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // The set of all tasks that the boss sees
        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All tasks", tasks);

        // Ann's Tasks
        //This comparator works because high, medium and low are indexes 0, 1, and 2
        //in the Priority enum
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annsTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann's tasks", annsTasks, sortByPriority);

        // Getting a list of all assigned tasks to a team member
        Set<Task> bobsTask = TaskData.getTasks("Bob");
        Set<Task> carolsTask = TaskData.getTasks("Carol");
        List<Set<Task>> sets = List.of(annsTasks, bobsTask, carolsTask);
        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("Assigned Tasks", assignedTasks);

        // All tasks - assigned and unassigned
        Set<Task> everyTask = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("All tasks - assigned and unassigned", everyTask);

        // Finding only missing tasks - tasks that are not on the boss' radar.
        Set<Task> missingTasks = getDifferences(everyTask, tasks);
        sortAndPrint("Missing tasks", missingTasks);

        // Finding tasks that are not assigned to anyone
        // There's a high priority task!
        Set<Task> unassignedTasks = getDifferences(tasks, assignedTasks);
        sortAndPrint("Unassigned Tasks", unassignedTasks, sortByPriority);

        // Finding if a single task has been assigned to multiple team members
        // Find set intersection across each employee with each other, then
        // do a set union of these intersections.
        Set<Task> overlap = getUnion(
                List.of(
                        getIntersect(annsTasks, bobsTask),
                        getIntersect(carolsTask, bobsTask),
                        getIntersect(annsTasks, carolsTask)
                )
        );
        sortAndPrint("Tasks assigned to multiple people", overlap, sortByPriority);

        // These are tasks with overlapping tasks. they need re allocation.
        List<Task> overlapping = new ArrayList<>();
        for (Set<Task> set: sets){
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority.thenComparing(
                Comparator.naturalOrder()
        );
        sortAndPrint("Overlapping", overlapping, priorityNatural);
    }

    private static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
        for (var taskSet : sets){
            union.addAll(taskSet);
        }
        return union;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b){
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifferences(Set<Task> a, Set<Task> b){
        Set<Task> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
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
