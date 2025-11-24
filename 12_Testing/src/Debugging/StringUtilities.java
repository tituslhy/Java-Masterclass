package Debugging;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0; //add breakpoint here will add a field watchpoint.

    public void addChar(StringBuilder sBuilder, char c){
        sBuilder.append(c); //add breakpoint here
        charsAdded++;
    }
}
