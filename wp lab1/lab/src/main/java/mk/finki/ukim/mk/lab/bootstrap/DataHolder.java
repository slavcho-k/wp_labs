package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movieList = new ArrayList<>(10);

    @PostConstruct
    public void init() {
        movieList.add(new Movie(
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                9.3
        ));
        movieList.add(new Movie(
                "Inception",
                "A thief who enters the dreams of others and steals their deepest secrets is tasked with planting an idea into the mind of a CEO.",
                8.8
        ));
        movieList.add(new Movie(
                "Forrest Gump",
                ": The life of a man with low intelligence, who accomplishes great things during his lifetime.",
                8.8
        ));
    }
}
