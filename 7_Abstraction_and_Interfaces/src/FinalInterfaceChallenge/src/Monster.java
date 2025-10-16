import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public List<String> write(){
        ArrayList<String> stringify = new ArrayList<>();
        stringify.add(name);
        stringify.add(Integer.toString(hitPoints));
        stringify.add(Integer.toString(strength));
        return stringify;
    }

    public void read(List<String> stringify){
        if (stringify != null && stringify.size() > 0) {
            this.name = stringify.get(0);
            this.hitPoints = Integer.parseInt(stringify.get(1));
            this.strength = Integer.parseInt(stringify.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }
}
