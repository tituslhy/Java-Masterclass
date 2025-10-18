package FunPass;

public class Concert implements Eventable{
    private String concertType;
    private String artiste;

    public Concert(String artiste){
        this("musical", artiste);
    }
    public Concert(String concertType, String artiste) {
        this.concertType = concertType;
        this.artiste = artiste;
    }

    @Override
    public String getEventDetails() {
        return String.format("This is a %s by %s", concertType, artiste);
    }
}
