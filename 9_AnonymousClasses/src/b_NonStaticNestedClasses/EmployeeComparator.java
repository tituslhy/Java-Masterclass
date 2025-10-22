package b_NonStaticNestedClasses;

import java.util.Comparator;

/*
This class strictly isn't needed - it cannot access the private attributes of the Employee class
 */
public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
