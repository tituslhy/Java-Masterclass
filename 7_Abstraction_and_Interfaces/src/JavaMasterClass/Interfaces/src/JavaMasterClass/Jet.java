package JavaMasterClass;

public class Jet implements FlightEnabled, Trackable {
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

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName()  + "'s coordinates recorded");
    }

    @Override
    public FlightStages transition(FlightStages stage) {
        System.out.println(getClass().getSimpleName() + " transitioning");

        // When you call a default method from an overriden method, you need to return a super type!
        return FlightEnabled.super.transition(stage);
    }
}
