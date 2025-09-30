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

        // This uses 'Object's default methods to get class and simple name. It tests for
        // the run time type. But it's not the best way. The 'instanceof' is a better way
        Object unknownObject = Movie.getMovie("C", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy"){
            Comedy c = (Comedy) unknownObject;
            c.watchMovie();
        } else if (unknownObject instanceof Adventure){
            // Cast to adventure
            ((Adventure) unknownObject).watchMovie();
        } else if (unknownObject instanceof ScienceFiction syfy){
            // we cast the object instance to a variable called syfy in the if
            // statement directly and call it in the code block.
            syfy.watchMovie();
        }
    }
}
