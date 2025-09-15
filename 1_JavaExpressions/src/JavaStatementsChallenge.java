public class JavaStatementsChallenge {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        int finalScore = score;
        if (gameOver){
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score for the setup was: " + finalScore);
        }

        // The challenge.
        score = 10_000;
        levelCompleted = 8;
        bonus = 200;
        if (gameOver){
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score for the challenge was: " + finalScore);
        }
    }
}
