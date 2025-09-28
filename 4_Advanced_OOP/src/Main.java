public class Main {
    public static void main(String[] args) {
        ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27,"2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");
        PersonalComputer theComputer = new PersonalComputer("2208", "Dell", theMonitor, theMotherboard, theCase);

        theComputer.powerUp();
        // This is one way to use a method from a composite class
//        theComputer.getMonitor().drawPixelAt(10, 10, "red");
//        theComputer.getMotherboard().loadProgram("Windows OS");

    }
}
