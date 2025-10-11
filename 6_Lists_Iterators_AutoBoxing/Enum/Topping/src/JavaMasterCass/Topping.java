package JavaMasterCass;

/*
To add methods to an enum, always add a ";" to the last attribute
 */
public enum Topping {
    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO;

    /*
    Return the enum itself in the switch within a method of an enum. Wow?
     */
    public double getPrice(){
        return switch(this){
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }
}
