package GenericLesson2;

import java.util.ArrayList;
import java.util.List;

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
}
