package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieTitle;
    private Long numberOfTickets;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateCreated;

    public Ticket(String movieTitle, long numOfTickets, ShoppingCart shoppingCart, LocalDateTime dateCreated) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numOfTickets;
        this.shoppingCart = shoppingCart;
        this.dateCreated = (LocalDateTime) Objects.requireNonNullElseGet(
                dateCreated,
                () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );
    }

    @Override
    public String toString() {
        return String.format("User: %s Movie: %s Tickets: %s", shoppingCart.getUser().getPersonName().getName(), movieTitle, numberOfTickets);
    }
}
