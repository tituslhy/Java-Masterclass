public class Main {
    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        System.out.println(tim.write());

        Monster werewolf = new Monster("Werewolf", 20, 40);
        System.out.println(werewolf.toString());
        System.out.println(werewolf.write());
    }
}
