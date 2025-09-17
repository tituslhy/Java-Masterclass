public class IsLeapYear {
    public boolean isLeapYear(int year){
        return switch (true){
            case ((year < 1) || (year > 9999)) -> false;
            case (((year % 4 == 0) && (year % 100 !=0)) || (year % 400 == 0)) -> true;
            default -> false;
        };
    }
}
