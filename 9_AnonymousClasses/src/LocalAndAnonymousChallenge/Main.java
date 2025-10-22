package LocalAndAnonymousChallenge;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

record Employee(String firstName, String lastName, String hireDate) {}

public class Main {
    public static void main(String[] args) {
        var bob = new Employee("Bob", "Sullivan", "2011-09-11");
        var tom = new Employee("Tom", "Lee", "2021-01-21");
        var jerry = new Employee("Jerry", "Goh", "2012-12-12");

        var employees = new ArrayList<Employee>(List.of(bob, tom, jerry));
        System.out.print(getEmployeeMetadata(employees));

    }

    public static String getEmployeeMetadata(List<Employee> employees){
        StringBuilder return_string = new StringBuilder();

        class EmployeeMetadataComputer{
            private Employee employee;

            public EmployeeMetadataComputer(Employee employee) {
                this.employee = employee;
            }

            @Override
            public String toString() {
                LocalDate currentDate = LocalDate.now();
                String[] splits = employee.hireDate().split("-");
                LocalDate joinDate = LocalDate.of(
                        Integer.parseInt(splits[0]),
                        Integer.parseInt(splits[1]),
                        Integer.parseInt(splits[2])
                );
                Period period = Period.between(joinDate, currentDate);
                return "%s %s: Years of service: %s years %s months and %s days".formatted(
                        employee.firstName(),
                        employee.lastName(),
                        period.getYears(),
                        period.getMonths(),
                        period.getDays()
                );
            }
        }

        for (var employee : employees){
            var computer = new EmployeeMetadataComputer(employee);
            return_string.append(computer.toString()).append("\n\n");
        }

        return return_string.toString();
    }
}
