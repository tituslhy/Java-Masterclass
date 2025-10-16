package JavaMasterclass;

interface Player {
    String name(); //This does not force a change to a record
}

record BaseballPlayer (String name, String position) implements Player {}
record FootballPlayer (String name, String position) implements Player {}
record VolleyballPlayer (String name, String position) implements Player {}

public class Main {
    public static void main(String[] args) {

        // Say we create a new app for baseball team - this is the implementation
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResults(phillies1, 3, astros1, 5);

        // But it works so well that the soccer league wants to use our app for soccer teams.
        // So we add an interface named Player and have records implement Player
        // And change BaseBallTeam to a generic SportsTeam class.
        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResults(phillies2, 3, astros2, 5);

        // This allows us to create soccer teams.
        // But the problem with this approach is you can even add Baseball Players into a Soccer Team!
        // Generics can allow for further type checking and is the preferred way
        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        //        afc1.addTeamMember(guthrie); //this will pass!

        //This use of generic class `Team` means that you can only add Baseball Players
        //Don't use the generics in raw form. Specify the class when you instantiate them
        Team<BaseballPlayer> phillies = new Team<>("Philadelphia Phillies");
        Team<BaseballPlayer> astros = new Team<>("Houston Astros");
        scoreResults(phillies, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();

        Team<FootballPlayer> afc = new Team<>("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Center half forward");
        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
        afc.addTeamMember(tex);
//        afc.addTeamMember(guthrie); //this will now have an error when you're adding to the football team!
        afc.listTeamMembers();

        // But you can even create a Team of type string! the generic classes work regardless!
        // This works: Team<String> adelaide = new Team<>("Adelaide Storm"); if Team<T> is the definition
        // Which is why you have to define Team<T extends Player> in your generic class
        // Either that - or just add a "name" method to the Interface
        var adelaide = new Team<VolleyballPlayer>("Adelaide Storm");
        var roberts = new VolleyballPlayer("N Roberts", "Setter");
        adelaide.addTeamMember(roberts);
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResults(canberra, 0, adelaide, 1);
    }

    public static void scoreResults(
        BaseballTeam team1, int t1_score,
        BaseballTeam team2, int t2_score
    ){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResults(
            SportsTeam team1, int t1_score,
            SportsTeam team2, int t2_score
    ){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    /*
    Generics are tricky when used in methods. This usage gets a warning
    because we are using the generic class `Team` in raw form.
     */
    public static void scoreResults(
            Team team1, int t1_score,
            Team team2, int t2_score
    ){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
