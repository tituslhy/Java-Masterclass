/*
This class inherits from Product while being composed by other
classes which also inherit from Product.
 */
public class PersonalComputer extends Product{
    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;

    public PersonalComputer(
            String model,
            String manufacturer,
            Monitor monitor,
            Motherboard motherboard,
            ComputerCase computerCase)
    {
        super(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;
    }

    /*
    Hidden method
     */
    private void drawLogo(){
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    public void powerUp(){
        computerCase.pressPowerButton();
        drawLogo();
    }

    // In reality we don't want to expose these lower level functions
    // in our computer
//    public Monitor getMonitor() {
//        return monitor;
//    }
//
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
//
//    public ComputerCase getComputerCase() {
//        return computerCase;
//    }
}
