public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        // WE can do this because access is public. This potentially bypasses
        // checks and additional methods your class has in place for errors.
        player.name = "Titus";
        player.health = 20; // for example, you can set this to 200 which is more than 100!
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        EnhancedPlayer titus = new EnhancedPlayer("Titus");
    }
}
