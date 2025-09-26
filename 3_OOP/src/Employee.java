public class Employee extends Worker{
    private Long employeeId;
    private String hireDate;
    private static int employeeNo = 1;

    public Employee(String birthDate, String endDate, String name, String hireDate) {
        super(birthDate, endDate, name);
        this.employeeId = (long) Employee.employeeNo++;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", hireDate=" + hireDate +
                ", name='" + name + '\'' +
                ", endDate='" + endDate + '\'' +
                "} " + super.toString();
    }
}
