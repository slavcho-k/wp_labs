package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.Ticket;
import mk.finki.ukim.mk.lab.repository.jpa.TicketRepository;
import mk.finki.ukim.mk.lab.service.TicketService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public void addTicket(String movieTitle, int numOfTickets, ShoppingCart shoppingCart, LocalDateTime dateTime) {
        if (dateTime != null) {
            ticketRepository.save(new Ticket(movieTitle, numOfTickets, shoppingCart, dateTime));
        } else {
            ticketRepository.save(new Ticket(movieTitle, numOfTickets, shoppingCart, null));
        }
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll().stream().toList();
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public void removeTicket(Long id) {
        ticketRepository.delete(ticketRepository.findById(id).get());
    }

    @Override
    public void makeDuplicate(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);

        ticketOptional.ifPresent(ticket -> ticketRepository.save(new Ticket(
                "Duplicate of " + ticket.getMovieTitle(),
                ticket.getNumberOfTickets(),
                ticket.getShoppingCart(),
                LocalDateTime.now())));
    }
}
