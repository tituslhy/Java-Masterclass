public class Main {
    public static void main(String[] args) {
        SalariedEmployee titus = new SalariedEmployee(
            "11/11/1985",
            "00/00/0000",
            "Titus",
            "01/01/2025",
            81_521.29,
            false
        );
        System.out.println(titus);
        System.out.println("Age = " + titus.getAge());
        System.out.println(titus.CollectPay());

        HourlyEmployee joe = new HourlyEmployee(
            "11/11/1984",
            "00/00/0000",
            "Joe",
            "01/01/2024",
            50.95
        );
        System.out.println(joe);
        System.out.println("Age = " + joe.getAge());
        System.out.println(joe.CollectPay());
        System.out.println(joe.getDoublePay());

//        ComplexNumber one = new ComplexNumber(1.0, 1.0);
//        ComplexNumber number = new ComplexNumber(2.5, -1.5);
//        one.add(1,1);
//        System.out.println("one.real= " + one.getReal());
//        System.out.println("one.imaginary= " + one.getImaginary());
//        one.subtract(number);
//        System.out.println("one.real= " + one.getReal());
//        System.out.println("one.imaginary= " + one.getImaginary());
//        number.subtract(one);
//        System.out.println("number.real= " + number.getReal());
//        System.out.println("number.imaginary= " + number.getImaginary());

//        Wall wall = new Wall(5,4);
//
//        System.out.println("area = " + wall.getArea());
//        // Invoking car class
//        Car car = new Car();
//        car.setConvertible(false);
//        car.setColor("Pearl White");
//        car.setDoors(4);
//        car.setMake("Tesla");
//        car.setModel("Model X");
//        car.describeCar();
//
//        // Invoking bank account class
//        MyBankAccount emptyAccount = new MyBankAccount();
//        MyBankAccount myBankAccount = new MyBankAccount("Bob", "Bob@123.com", "12345");
//        System.out.println(myBankAccount.getAccountBalance());
//
//        // Invoking our Student POJO
//        for (int i = 0; i <=5; i++){
//            Student s = new Student(
//                    "S93400" + i,
//                    switch(i){
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        default -> "Lisa";
//                    },
//                    "05/11/1985",
//                    "Java Masterclass"
//            );
//            System.out.println(s.toString());
//        }
//
//        System.out.println();
//
//        // Invoking our LPAStudent record
//        for (int i = 0; i <=5; i++){
//            LPAStudent s = new LPAStudent(
//                    "S93400" + i,
//                    switch(i){
//                        case 1 -> "Mary";
//                        case 2 -> "Carol";
//                        case 3 -> "Tim";
//                        case 4 -> "Harry";
//                        default -> "Lisa";
//                    },
//                    "05/11/1985",
//                    "Java Masterclass"
//            );
//            System.out.println(s.toString());
//            // To get the attribute of the class, use attribute(), not
//            // getAttribute().
//            System.out.println(s.name());
//        }
    }
}
