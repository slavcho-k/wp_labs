package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    public List<Ticket> tickets;

    public TicketRepository() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> findAll() {
        return tickets;
    }

    public Ticket findById(long id) {
        return tickets.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addTicket(Ticket ticket) {
        tickets.stream()
                .filter(t -> t.getId().equals(ticket.getId()))
                .findFirst().ifPresent(existing -> tickets.remove(existing));

        tickets.add(ticket);
    }
}
