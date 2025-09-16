public class MethodOverloading {
    public static void main(String[] args) {
        int newScore = calculateScore("Titus", 500);
        System.out.println("New score is: " + newScore);
        int unNamedScore = calculateScore(75);
        System.out.println("Unnamed score: " + unNamedScore);
    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player" + playerName + " scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed Player scored" + score + " points");
        return score * 1000;
    }
}
