package Lesson.One.CollectionsOverview;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // The Collection Interface is a more abstracted interface than List.

//        List<String> list = new ArrayList<>();
//        Collection<String> list = new ArrayList<>();
//        Collection<String> list = new TreeSet<>();
        Collection<String> list = new HashSet<>(); //unsorted
        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gary", "Grace"));
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));

        list.removeIf(s-> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gary is in the list? " + list.contains("Gary"));
    }
}
