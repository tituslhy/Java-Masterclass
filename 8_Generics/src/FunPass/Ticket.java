package FunPass;

public class Ticket <T extends Eventable>{
    private String ticketId;
    private double price;
    private T eventDetails;

    public Ticket(String ticketId, double price, T eventDetails) {
        this.ticketId = ticketId;
        this.price = price;
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        String details = (eventDetails instanceof Eventable)
                ? ((Eventable) eventDetails).getEventDetails()
                : eventDetails.toString();
        return String.format("Ticket{ticketId='%s', price=%.2f, eventDetails=%s}",
                ticketId, price, details);
    }
}
