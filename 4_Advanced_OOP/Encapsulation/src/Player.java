/*
This is a player in a computer game.

Notice that the attributes are public! Also notice that there isn't
any constructor for this class. This just means the class can be
constructed without any attributes but they need to be manually
set once constructed.
 */
public class Player {
    public String name;
    public int health;
    public String weapon;

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
