public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.setConvertible(false);
//        car.setColor("Pearl White");
//        car.setDoors(4);
//        car.setMake("Tesla");
//        car.setModel("Model X");
//        car.describeCar();
//        MyBankAccount emptyAccount = new MyBankAccount();
//        MyBankAccount myBankAccount = new MyBankAccount("Bob", "Bob@123.com", "12345");
//        System.out.println(myBankAccount.getAccountBalance());

        // Invoking our POJO
        for (int i = 0; i <=5; i++){
            Student s = new Student(
                    "S93400" + i,
                    switch(i){
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        default -> "Lisa";
                    },
                    "05/11/1985",
                    "Java Masterclass"
            );
            System.out.println(s.toString());
        }

        System.out.println();

        // Invoking our record
        for (int i = 0; i <=5; i++){
            LPAStudent s = new LPAStudent(
                    "S93400" + i,
                    switch(i){
                        case 1 -> "Mary";
                        case 2 -> "Carol";
                        case 3 -> "Tim";
                        case 4 -> "Harry";
                        default -> "Lisa";
                    },
                    "05/11/1985",
                    "Java Masterclass"
            );
            System.out.println(s.toString());

        }
    }
}
