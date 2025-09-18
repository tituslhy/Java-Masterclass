public class Switches {
    public static void main(String[] args) {
        String month = "April";
        System.out.println(month + " is in the " + getQuarter(month) + " quarter.");
        printValue(3);
    }

    public static void printValue(int switchValue) {

        // The enhanced version
        switch (switchValue){
            case 1 -> System.out.println("Value was 1");
            case 2 -> System.out.println("Value was 2");
            case 3, 4, 5 -> {
                System.out.println("Was a 3, 4, or 5");
                System.out.println("Was actually a " + switchValue);
            }
            default -> System.out.println("Was not 1,2,3,4, or 5.");
        }
    }
    public static String getQuarter(String month){
        // The traditional way - this is compatible with older Java versions.
//        switch (month){
//            case "January":
//            case "February":
//            case "March":
//                return "1st";
//            case "April":
//            case "May":
//            case "June":
//                return "2nd";
//            case "July":
//            case "August":
//            case "September":
//                return "3rd";
//            case "October":
//            case "November":
//            case "December":
//                return "4th";
//        }
//        return "bad";
//
//

        // The enhanced version
        return switch (month){
            case "January", "February", "March" -> "1st";
            case "April", "May", "June" -> "2nd";
            case "July", "August", "September" -> "3rd";
            case "October", "November", "December" -> "4th";
            default -> { //include a default case
                String badResponse = month + " is not a month";
                yield badResponse; // IntelliJ will complain if you have a return within a return statement. Use yield.
                // yield statements must ALWAYS be in a code block {yield <var> ;} even in switches.
            }
        };
    }
}
