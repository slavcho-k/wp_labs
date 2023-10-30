package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {

    public List<Movie> findall() {
        return DataHolder.movieList;
    }

    public List<Movie> searchMovies(String text, Long rating) {
        return DataHolder.movieList.stream()
                .filter(m -> m.getTitle().contains(text) && m.getRating() >= rating)
                .toList();
    }
}
