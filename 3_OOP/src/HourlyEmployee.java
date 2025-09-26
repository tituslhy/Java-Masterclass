public class HourlyEmployee extends Employee{
    private double hourlyPayRate;

    public HourlyEmployee(
        String birthDate,
        String endDate,
        String name,
        String hireDate,
        double hourlyPayRate
    ) {
        super(birthDate, endDate, name, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double CollectPay() {
        //Pay per day
        return Math.ceil(hourlyPayRate * 8);
    }

    public double getDoublePay(){
        return Math.ceil(2.0 * 8 *CollectPay());
    }
}
