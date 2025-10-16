import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public List<String> write(){
        ArrayList<String> stringify = new ArrayList<>();
        stringify.add(name);
        stringify.add(Integer.toString(hitPoints));
        stringify.add(Integer.toString(strength));
        stringify.add(weapon);
        return stringify;
    }

    public void read(List<String> stringify){
        if (stringify != null && stringify.size() > 0) {
            this.name = stringify.get(0);
            this.hitPoints = Integer.parseInt(stringify.get(1));
            this.strength = Integer.parseInt(stringify.get(2));
            if (this instanceof Player) {
                this.weapon = stringify.get(3);
            }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon  + '\''+
                '}';
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
