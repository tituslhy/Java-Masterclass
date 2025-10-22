package d_AnonymousClasses;

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
        System.out.println("With Pig Latin Names");
        addPigLatinName(storeEmployees);
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list){

        String lastName = "Piggy";

        /*
        Cannot add any modifiers here! It follows the access of the method.
        The only purpose of this class is to add a pigLatin name to the employee.
        Only exists for one purpose.
         */
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString(){
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (var employee: list){
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }
        newList.sort(null); //uses the comparable's compareTo method
        for (var dEmployee : newList){
            //You're accessing private attributes from the super class
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }

    }
}
