package FunPass;

public class SportsMatch implements Eventable{
    private String matchType;
    private String homeTeam;
    private String awayTeam;
    private String location;

    public SportsMatch(String matchType, String homeTeam, String awayTeam, String location) {
        this.matchType = matchType;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.location = location;
    }

    @Override
    public String getEventDetails() {
        return String.format(
                "This is a %s between %s and %s at %s",
                matchType,
                homeTeam,
                awayTeam,
                location
        );
    }
}
