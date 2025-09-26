public class Worker {
    protected String name;
    private String birthDate; //mm/dd/yyyy format
    protected String endDate;

    public Worker(String birthDate, String endDate, String name) {
        this.birthDate = birthDate;
        this.endDate = endDate;
        this.name = name;
    }

    public int getAge(){
        int currentYear = 2025;
        //Assuming dates are in dd/mm/yyyy
        return currentYear - Integer.parseInt(birthDate.substring(6));
    }

    public double CollectPay(){
        return 0.0;
    }

    public void terminate (String endDate){
        this.endDate = endDate;
    }
}
