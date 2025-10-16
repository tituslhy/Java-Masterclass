package JavaMasterclass;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode){
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}

/*
In this case we set the Team class to be a generic of type T which is the type of Player.
So if we insert soccer players we cannot insert football players anymore.

Generic classes cannot be used on primitives like 'int' but you can use 'Integer'.
 */
public class Team<T extends Player, S> {
    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T player){
        if (!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.print(teamName + " Roster");
        System.out.print((affiliation == null? "" : " AFFILIATION: " + affiliation));
        for (T t: teamMembers){
            System.out.println(t.name());
        };
    }

    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore > theirScore){
            totalWins++;
            message = "beat";
        } else if (ourScore == theirScore){
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
