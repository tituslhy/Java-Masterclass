public class JavaMethodsChallenge {
    public static void displayHighScorePosition(
        String playerName, int position
    ){
        System.out.println(playerName + " managed to get into position " + position + " on the high score list.");
    }

    public static int calculateHighScore(int playerScore){
        if (playerScore >=1000){
            return 1;
        } else if (
            (playerScore>=500) && (playerScore<1000)
        ){
            return 2;
        } else if (
            (playerScore>=100) && (playerScore<500)
        ){
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        String playerName = "Titus";
        int [] scores = {1500, 1000, 500, 100, 25};
        for (int score: scores){
            System.out.println("Calculating " + playerName + "'s position for score: " + score);
            displayHighScorePosition(
                playerName, calculateHighScore(score)
            );
        }

    }
}
