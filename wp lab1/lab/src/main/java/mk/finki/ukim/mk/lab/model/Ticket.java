package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    Long id;
    String client;
    String movieTitle;
    int numOfTickets;

    public Ticket(String client, String movieTitle, int numOfTickets) {
        this.id = (long) (Math.random() * 10000);
        this.client = client;
        this.movieTitle = movieTitle;
        this.numOfTickets = numOfTickets;
    }

    @Override
    public String toString() {
        return String.format("User: %s Movie: %s Tickets: %s", client, movieTitle, numOfTickets);
    }
}
