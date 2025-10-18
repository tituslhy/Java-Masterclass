package GenericLesson2;

import GenericLesson2.util.QueryItem;
import GenericLesson2.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        //Create your array of students
        int studentCount = 10;
        List<LPAStudent> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++){
            students.add(new LPAStudent());
        }

//        printList(students);
        printMoreLists(students);

        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1,2,3)));

        var queryList = new QueryList<>(students);
        var matches = queryList.getMatches("Course", "Python");
        printMoreLists(matches);

        var students2021 = QueryList.getMatches(students,"YearStarted", "2021");
        printMoreLists(students2021);

//        QueryList<Employee> employeeList = new QueryList<>();
    }

    /*
    For a method, type parameters are placed after any modifiers and before the method's
    return type.

    The type parameter can be referenced in method parameters, as the method's return type
    and used in the method code block.

    A generic method can be used for a non-generic class.

    T extends Student means you can use Student or Student's descendants. It's the upper bound.
     */
    public static <T extends Student> void printList(List<T> students){
        for (var student: students){
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    /*
    Wild cards cannot be used inside an ArrayList - ArrayList<?>
     */
    public static void printMoreLists(List<? extends Student> students){
        for (var student: students){
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for (var element: list){
            if (element instanceof String s){
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i){
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

    //Type erasure - these 2 methods do not overload!
//    public static void testList(List<String> list){
//        for (var element: list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//        for (var element: list){
//            System.out.println("Integer: " + element.floatValue());
//        }
//    }
}
