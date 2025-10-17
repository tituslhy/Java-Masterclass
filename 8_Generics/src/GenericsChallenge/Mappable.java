package GenericsChallenge;

import java.util.Arrays;

public interface Mappable {
    void render();

    static double[] stringToLatLong(String location){
        var splits = location.split(",");
        double lat = Double.valueOf(splits[0]);
        double lng = Double.valueOf(splits[1]);
        return new double[]{lat, lng};
    }
}

abstract class Point implements Mappable {
    private double[] location = new double[2]; //holds only lat and lng

    public Point(String location) {
        this.location = Mappable.stringToLatLong(location);
    }

    private String location(){
        return Arrays.toString(location);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }
}

abstract class Line implements Mappable {
    private double[][] locations;

    public Line(String... locations){
        this.locations = new double[locations.length][];
        int index = 0;
        for (var l : locations){
            this.locations[index++] = Mappable.stringToLatLong(l);
        }
    }

    private String locations(){
        return Arrays.deepToString(locations);
    }

    @Override
    public void render() {
        System.out.println("Render " + this + " as LINE (" + locations() + ")");
    }

}