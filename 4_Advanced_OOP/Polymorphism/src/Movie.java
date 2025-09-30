public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

    // Equivalent to Python's class method. creates a new class.
    // This is known as a factory method - obtaining the method without knowing the object
    public static Movie getMovie(String type, String title){
        return switch(type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // Plot stages
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something bad happens"
        );
    }
}

class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // Plot stages
        System.out.printf(".. %s%n".repeat(3),
                "Something funny happens",
                "Something even funnier happens",
                "Happy ending"
        );
    }
}

class ScienceFiction extends Movie {
    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // Plot stages
        System.out.printf(".. %s%n".repeat(3),
                "Bad aliens to bad stuff",
                "Space guys chase aliens",
                "Planet blows up"
        );
    }
}
