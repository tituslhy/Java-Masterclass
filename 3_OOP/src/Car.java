public class Car {

    // Always have private fields, then add get/set methods
    // if you need to access these fields.
    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible;

    // Getters
    public String getMake(){
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    // Setter methods
    public void setMake(String make) {
        // Add validation methods for setting
        if(make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch (lowercaseMake){
            case "bmw", "porsche", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            }
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    /**
     * This method is not static because we are accessing
     * instance fields on the class.
     */
    public void describeCar(){
        System.out.println(
            doors + "-Doors " +
            color + " " +
            make + " " +
            model + " " +
            (convertible ? "Convertible" : "")
        );
    }
}
