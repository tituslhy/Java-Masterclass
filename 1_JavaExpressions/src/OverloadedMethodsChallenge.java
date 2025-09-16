public class OverloadedMethodsChallenge {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(6) + " cm.");
        System.out.println(convertToCentimeters(5, 7) + " cm.");
        System.out.println(getDurationString(-3600));
        System.out.println(getDurationString(-59, 60));
    }

    public static double convertToCentimeters(int height_inches){
        return height_inches * 2.54;
    }

    public static double convertToCentimeters(int height_feet,int remaining_height_inches){
        int total_height_inches = height_feet * 12 + remaining_height_inches;
        return convertToCentimeters(total_height_inches);
    }

    public static String getDurationString(int seconds){
        if (seconds < 0){
            return "Seconds must be a positive integer value.";
        }
        int hours = (int) seconds/3600;
        int minutes = (int) (seconds-hours*3600)/60;
        int seconds_left = (int) (seconds -hours*3600 - minutes*60);
        return hours + "h "+ minutes + "m " + seconds_left + "s";
    }

    public static String getDurationString(int minutes, int seconds){
        if (seconds>59){
            return "Error. Seconds is greater than 59 seconds.";
        } else if ((seconds < 0) || (minutes < 0)){
            return "Error. Seconds and minutes must be positive integers.";
        }
        int total_seconds = minutes * 60 + seconds;
        return getDurationString(total_seconds);
    }
}
