public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Titus!");

        //Add a conditional. Wrap if-else statements in code blocks
        boolean isAlien = false;
        if (!isAlien) {
            System.out.println("Titus is not an Alien.");
            System.out.println("And I am scared of aliens");
        }

        int topScore=80;
        if (topScore <= 100){
            System.out.println("You got the high score!");
        }

        int secondTopScore = 60;
        // Add code indentation and parenthesis on if blocks for easier readability.
        if (
                (topScore > secondTopScore) &&
                (topScore < 100)
        ){
            System.out.println("Greater than second top score and less than 100");
        }

        if (
                (topScore > 90) || (secondTopScore <= 90)
        ){
            System.out.println("Either or both of the conditions above are true.");
        }

        // Beware the difference between '=' and '=='. '=' is an assignment operator
        // '==' is used for comparison.
        int newValue = 50;
        if (newValue==50){
            System.out.println("This is an error");
        }

        boolean isCar = false;
        if (isCar == true){
            System.out.println("This is not supposed to happen");
        }

        // Add operands
        String makeOfCar = "Volkswagen";

        // if Volkswagen is the make of car, then it's not domestic.
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if (isDomestic){
            System.out.println("This car is domestic to our country.");
        }

        String s = (isDomestic) ? "This car is domestic": "This car is not domestic";
        System.out.println(s);
    }
}
