public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        // Alternatively:
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();
        // Remember to cast the type with '(Adventure)';

        // This tells IntelliJ to infer the instance type at run time, not compile time (default)
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();
    }
}
