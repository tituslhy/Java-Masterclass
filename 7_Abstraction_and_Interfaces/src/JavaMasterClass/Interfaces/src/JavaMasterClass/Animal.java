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

//        System.out.println(
//                "Transition not implemented on " + this.getClass().getName()
//        );
//        return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface OrbitEarth extends FlightEnabled{

    void achieveOrbit();

    //Only concrete methods in the interface can call it.
    private static void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;
    }
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

    public FlightStages getNextStage(){
        FlightStages[] allStages = values();

        //Return the next stage except if it's the last stage (DATA_COLLECTION),
        //so we return the first stage instead.
        return allStages[(ordinal() + 1) % allStages.length];
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
    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while orbiting");
    }

    //Overloading the interface's transition method
    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }

}

interface Trackable {

    void track();
}

public abstract class Animal {
    public abstract void move ();
}
