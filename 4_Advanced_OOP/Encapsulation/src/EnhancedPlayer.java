public class EnhancedPlayer {
    // THis time with proper encapsulation - keeping the fields private. don't allow
    // external usage to reset these fields easily.
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name){
        this(name, 100, "Sword");
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health <=0){
            this.health = 1;
        } else if (health > 100){
            this.health = 100;
        } else {
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        health -= damage;
        if (health <=0){
            System.out.println("Player knocked outof game");
        }
    }

    public int healthRemaining(){
        return health;
    }

    public void restoreHealth(int extraHealth){
        health += extraHealth;
        if (health > 100){
            health = 100;
        }
    }
}
