package JavaMasterClass;

interface FlightEnabled {

    //Any attribute defined in the interface is automatically public and final. It cannot be redefined.
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES=  0.621371;

    void takeOff();

    void land();

    //Any method declared without a body is immediately public and abstract by default
    void fly();

    default FlightStages transition(FlightStages stage){
        // It's common practice to write a statement or throw an exception to inform the user that
        // this new method needs override - but does not force them to . Their code still compiles.
        System.out.println(
                "Transition not implemented on " + this.getClass().getName()
        );
        return null;
    }
}

interface OrbitEarth extends FlightEnabled{

    void achieveOrbit();
}

/*
Each defined stages in the enum are trackable
 */
enum FlightStages implements Trackable {

    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED){
            System.out.println("Monitoring " + this);
        }
    }
}


record DragonFly(String name, String type) implements FlightEnabled{

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

class Satellite implements OrbitEarth{
    @Override
    public void achieveOrbit() {
        System.out.println("Orbit achieved");
    }

    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName()  + " is taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName()  + " is landing");
    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName()  + " is flying");
    }
}

interface Trackable {

    void track();
}

public abstract class Animal {
    public abstract void move ();
}
