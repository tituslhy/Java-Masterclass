package NonStaticNestedClasses;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(
                List.of(
                        new StoreEmployee(10015, "Meg", 2019, "Target"),
                        new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                        new StoreEmployee(10105, "Tom", 2020, "Macys"),
                        new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                        new StoreEmployee(10322, "Bud", 2016, "Target")
                )
        );

        // This doesn't work because you're using the static Employee comparator. The subclass inherits
        // the internal comparator as well!
        var comparator = new StoreEmployee.EmployeeComparator<>();
        storeEmployees.sort(comparator);
        for (StoreEmployee e: storeEmployees){
            System.out.println(e);
        }

        System.out.println("-".repeat(30));
        // This is how you instantiate the `StoreEmployee` class' `StoreComparator`
        // The constructor should have no arguments instantiated.
        var correct_comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(correct_comparator);
        for (StoreEmployee e: storeEmployees){
            System.out.println(e);
        }

    }
}
