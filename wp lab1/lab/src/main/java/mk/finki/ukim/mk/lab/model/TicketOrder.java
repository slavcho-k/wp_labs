package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOrder {
    String movieTitle;
    String clientName;
    String clientAddress;
    Long numberOfTickets;
}
