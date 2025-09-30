import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie theMovie = new ScienceFiction("Star Wars");
//        theMovie.watchMovie();
//
//        //factory method implementation
//        Movie comedy = Movie.getMovie("Comedy", "The Big Bang Theory");
//        comedy.watchMovie();

        // Interactive CLI application
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
                    "S for Science Fiction, or Q to quit): ");
            String type = s.nextLine();
            if ("Qq".contains(type)){
                break;
            }
            System.out.print("Enter movie title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
