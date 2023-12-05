package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TicketService {
    void addTicket(String movieTitle, int numOfTickets, ShoppingCart shoppingCart, LocalDateTime dateTime);

    List<Ticket> findAll();

    Ticket findById(Long id);

    void removeTicket(Long id);

    void makeDuplicate(Long id);
}
