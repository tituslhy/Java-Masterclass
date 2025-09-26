public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(
        String birthDate,
        String endDate,
        String name,
        String hireDate,
        double annualSalary,
        boolean isRetired
    ) {
        super(birthDate, endDate, name, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    @Override
    public double CollectPay(){
        return Math.ceil(annualSalary/12);
    }

    public void retire(String endDate){
        super.terminate(endDate);
        isRetired = true;
        System.out.println(name + " has retired on " + endDate);
    }
}
