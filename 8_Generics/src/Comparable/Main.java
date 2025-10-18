package Comparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,5, 10, -50, 50};
        for (Integer i: others){
            int val = five.compareTo(i);
            System.out.printf(
                    "%d %s %d: compareTo=%d%n",
                    five,
                    (val==0 ? "==" : (val < 0) ? "<" : ">"),
                    i,
                    val
            );
        }

        // Notice that the comparison now gets a positive and negative integers
        // Chars are stored in memory as integer values. You're comparing integer values
        // within the string
        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        for (String s: fruit){
            int val = banana.compareTo(s);
            System.out.printf(
                    "%s %s %s: compareTo=%d%n",
                    banana,
                    (val==0 ? "==" : (val < 0) ? "<" : ">"),
                    s,
                    val
            );
        }
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        Student tim = new Student("Tim");
        Student[] students = {
                new Student("Zach"),
                new Student("Tim"),
                new Student("Ann"),
        };
        Arrays.sort(students); //This line blows up if we do not implement "comparable"
        System.out.println(Arrays.toString(students));
        System.out.println("result = " + tim.compareTo(new Student("TIM")));

        Comparator<Student>gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter); //sort using the GPAComparator method
        System.out.println(Arrays.toString(students)); //Ascending order

        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students)); //Descending order
    }
}

class StudentGPAComparator implements Comparator<Student>{
    /*
    The compare method must be implemented.
    Sort first by GPA, if it's a tie, sort by name.
     */
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}


/*
This implements the comparable interface
 */
class Student implements Comparable<Student>{

    protected String name;
    protected double gpa;

    private int id;
    private static int LAST_ID= 1000;
    private static Random random = new Random();

    public Student(String name){
        this.name=name;
        id = LAST_ID++; //no 2 student gets the same ID
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }

//    /*
//    This is NOT the recommended method. If you compare a string to a Student
//    for example, the type casting will fail.
//     */
//    @Override
//    public int compareTo(Object o) {
//        //Cast object to student
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }
}