package JavaMasterClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //How to declare a bird
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
        // These don't work! these are interfaces that aren't linked to the abstract class
//        flier.move();
//        tracked.move();

        inFlight(flier);
        inFlight(new Jet());

        Trackable truck = new Truck();
        truck.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf(
                "The truck traveled %.2f km or %.2f miles%n",
                kmsTraveled, milesTraveled
        );

        // The second method is better than the first. Use the interface as the type because
        // this clears more type errors.
        ArrayList<FlightEnabled> fliers = new ArrayList<>();
        fliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        List<FlightEnabled> betterFliers = new LinkedList<>();
        betterFliers.add(bird);

        triggerFliers(betterFliers);
        flyFliers(fliers);
        landFliers(fliers);

    }

    private static void triggerFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers){
        for (var flier:fliers){
            flier.land();
        }
    }

    private static void inFlight(FlightEnabled flier){
        flier.takeOff();
        flier.fly();
        if (flier instanceof Trackable tracked){
            tracked.track();
        }
        flier.land();
    }
}
