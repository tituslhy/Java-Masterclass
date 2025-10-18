package FunPass;

public class Movie implements Eventable{
    private double rating;
    private String movieName;

    public Movie(double rating, String movieName) {
        this.rating = rating;
        this.movieName = movieName;
    }

    @Override
    public String getEventDetails() {
        return String.format("This is a movie: %s with a rating of %.1f", movieName, rating);
    }
}
