public class Main {
    public static void main(String[] args) {
        ComplexNumber one = new ComplexNumber(1.0, 1.0);
        ComplexNumber number = new ComplexNumber(2.5, -1.5);
        one.add(1,1);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        one.subtract(number);
        System.out.println("one.real= " + one.getReal());
        System.out.println("one.imaginary= " + one.getImaginary());
        number.subtract(one);
        System.out.println("number.real= " + number.getReal());
        System.out.println("number.imaginary= " + number.getImaginary());

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
