public class Car{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine(){
        String instanceType = this.getClass().getSimpleName();
        return instanceType + " -> startEngine()";
    }

    public String accelerate(){
        String instanceType = this.getClass().getSimpleName();
        return instanceType + " -> accelerate()";
    }

    public String brake(){
        String instanceType = this.getClass().getSimpleName();
        return instanceType + " -> brake()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}

class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return super.startEngine();
    }

    @Override
    public String accelerate() {
        return super.accelerate();
    }

    @Override
    public String brake() {
        return super.brake();
    }
}
