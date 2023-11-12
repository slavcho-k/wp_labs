package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> listAll();

    List<Movie> searchMovies(String text, Long rating);

    void saveMovie(String movieTtile, String summary, double rating, String productionName, Long id);

    void deleteMovie(Long movieId);

    Movie findMovieById(Long id);
}
