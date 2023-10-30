package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> findAll() {
        return DataHolder.movieList;
    }

    public List<Movie> searchMovies(String text, Long rating) {
        return DataHolder.movieList.stream()
                .filter(m -> {
                    if (text != null && rating != null) {
                        return m.getTitle().toLowerCase().contains(text.toLowerCase()) && m.getRating() >= rating;
                    } else if (text != null) {
                        return m.getTitle().toLowerCase().contains(text.toLowerCase());
                    } else {
                        return m.getRating() >= rating;
                    }
                })
                .toList();
    }
}
