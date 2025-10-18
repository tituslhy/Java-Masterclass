package FunPass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var tSwift = new Concert("pop", "Taylor Swift");
        var jurassicWorld = new Movie(4.5, "Jurassic World");
        var derby = new SportsMatch("Football", "Manchester United", "Manchester City", "Old Trafford");

        var tickets = new ArrayList<Ticket<?>>();
        tickets.add(new Ticket<Concert>("tswift_pop", 400.21, tSwift));
        tickets.add(new Ticket<Movie>("j_world", 12.00, jurassicWorld));
        tickets.add(new Ticket<SportsMatch>("manchester_derby", 510.98, derby));

        for (Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }
}
