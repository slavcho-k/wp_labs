package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    void addTicket(long id, String client, String movieTitle, int numOfTickets);
    List<Ticket> findAll();

    Ticket findById(Long id);
}
