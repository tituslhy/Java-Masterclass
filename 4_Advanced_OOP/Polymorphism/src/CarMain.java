public class CarMain {
    public static void main(String[] args) {
        Car baseCar = new Car(4, "car");
        baseCar.startEngine();
        baseCar.accelerate();
        baseCar.brake();

        Mitsubishi mitsubishi = new Mitsubishi(6, "Outlander VRX 4WD");
        mitsubishi.startEngine();
        mitsubishi.accelerate();
        mitsubishi.brake();
    }
}
