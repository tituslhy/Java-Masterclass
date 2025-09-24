public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.setConvertible(false);
//        car.setColor("Pearl White");
//        car.setDoors(4);
//        car.setMake("Tesla");
//        car.setModel("Model X");
//        car.describeCar();
        MyBankAccount emptyAccount = new MyBankAccount();
        MyBankAccount myBankAccount = new MyBankAccount("Bob", "Bob@123.com", "12345");
        System.out.println(myBankAccount.getAccountBalance());
    }
}
