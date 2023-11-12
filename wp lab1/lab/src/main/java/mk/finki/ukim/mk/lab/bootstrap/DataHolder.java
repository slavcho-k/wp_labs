package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movieList = new ArrayList<>(10);
    public static List<Production> productions = new ArrayList<>(5);

    @PostConstruct
    public void init() {
        productions.add(new Production("ABC Studios", "United States", "123 Hollywood Blvd, Los Angeles"));
        productions.add(new Production("XYZ Films", "Macedonia", "456 Alexander the Great, Skopje"));
        productions.add(new Production("FilmCo LTD", "Russia", "789 Some Street, St. Petersburg"));
        productions.add(new Production("Mega Productions", "Australia", "567 Cinema Parade, Sydney"));
        productions.add(new Production("CineMagic", "Hungary", "007 James Bond, Budapest"));

        movieList.add(new Movie(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                9.3,
                productions.get((int) (Math.random() * 5))
        ));
        movieList.add(new Movie(
                "Inception",
                "A thief who enters the dreams of others and steals their deepest secrets is tasked with planting an idea into the mind of a CEO.",
                8.8,
                productions.get((int) (Math.random() * 5))
        ));
        movieList.add(new Movie(
                "Forrest Gump",
                ": The life of a man with low intelligence, who accomplishes great things during his lifetime.",
                8.8,
                productions.get((int) (Math.random() * 5))
        ));
    }

}
