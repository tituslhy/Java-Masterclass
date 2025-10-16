package JavaMasterClass;

public class Test {
    public static void main(String[] args) {
        inFlight(new Jet());
        orbit(new Satellite());
//        OrbitEarth.log("Testing" + new Satellite());
    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if (flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }

    private static void orbit(OrbitEarth orbiter){
        orbiter.takeOff();
        orbiter.fly();
        orbiter.land();
    }
}
