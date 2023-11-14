package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Ticket;
import mk.finki.ukim.mk.lab.repository.TicketRepository;
import mk.finki.ukim.mk.lab.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public void addTicket(long id, String client, String movieTitle, int numOfTickets) {
        Ticket ticket = ticketRepository.findById(id);
        if (ticket != null) {
            ticketRepository.tickets.remove(ticket);
        }
        ticketRepository.addTicket(new Ticket(client, movieTitle, numOfTickets));
        System.out.println(ticketRepository.findAll());
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findAll()
                .stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
