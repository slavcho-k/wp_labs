package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.jpa.MovieRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ProductionRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataHolder {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;

    @PostConstruct
    public void init() {
        if (userRepository.findAll().size() == 0) {
            userRepository.save(new User("slavcho", "karafilovski", "password", LocalDate.of(2002, 10, 3)));
            User user = userRepository.findUserByUsername("slavcho").get();
            shoppingCartRepository.save(new ShoppingCart(user));
        }

        if (productionRepository.findAll().size() == 0) {
            productionRepository.save(new Production("ABC Studios", "United States", "123 Hollywood Blvd, Los Angeles"));
            productionRepository.save(new Production("XYZ Films", "Macedonia", "456 Alexander the Great, Skopje"));
            productionRepository.save(new Production("FilmCo LTD", "Russia", "789 Some Street, St. Petersburg"));
            productionRepository.save(new Production("Mega Productions", "Australia", "567 Cinema Parade, Sydney"));
            productionRepository.save(new Production("CineMagic", "Hungary", "007 James Bond, Budapest"));
        }

        if (movieRepository.findAll().size() == 0) {
            movieRepository.save(new Movie(
                    "The Shawshank Redemption",
                    "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                    9.3,
                    productionRepository.findAll().get(0)
            ));
            movieRepository.save(new Movie(
                    "Inception",
                    "A thief who enters the dreams of others and steals their deepest secrets is tasked with planting an idea into the mind of a CEO.",
                    8.8,
                    productionRepository.findAll().get(0)
            ));
            movieRepository.save(new Movie(
                    "Forrest Gump",
                    ": The life of a man with low intelligence, who accomplishes great things during his lifetime.",
                    8.8,
                    productionRepository.findAll().get(0)
            ));
        }
    }
}
