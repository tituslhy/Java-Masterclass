/*
Create a class and name it Bed.
Five private member variables should be declared:
    style of type String, and
    pillows, height, sheets, quilt of type int.
A constructor should be coded which accepts these five member variables as parameters.
Also, six methods should be defined:
    make() has no return type and prints a message to the effect that the bed is being made;
    getStyle() which returns the value of style;
    getPillows() returns the number of pillows;
    getHeight() returns the height of the bed;
    getSheets() returns the number of sheets on the bed; and
    getQuilt() returns the value of quilt.
 */
public class Bed {
    private String style;
    private int pillows;
    private int height;
    private int sheets;
    private int quit;

    public Bed(String style, int pillows, int height, int sheets, int quit) {
        this.style = style;
        this.pillows = pillows;
        this.height = height;
        this.sheets = sheets;
        this.quit = quit;
    }

    public String getStyle() {
        return style;
    }

    public int getPillows() {
        return pillows;
    }

    public int getHeight() {
        return height;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuit() {
        return quit;
    }

    public void make(){
        System.out.print("Bed -> Making | ");
    }
}
