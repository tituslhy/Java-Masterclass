public class JavaStatementsChallenge {

    public static void main(String[] args) {
        System.out.println(
            "The first highScore is: "+ calculateScore(true, 800, 8, 200)
        );
        System.out.println(
            "The second highScore is: " + calculateScore(true, 10_000, 8, 200)
        );
    }

    public static int calculateScore(
        boolean gameOver, int score, int levelCompleted, int bonus
    ){
        int finalScore = score;
        if (gameOver){
            finalScore += (levelCompleted * bonus);
        }
        return finalScore;
    }
}
