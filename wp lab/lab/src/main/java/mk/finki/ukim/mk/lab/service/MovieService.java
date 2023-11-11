package mk.finki.ukim.mk.lab.service;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    List<Movie> listAll();

    List<Movie> searchMovies(String text, Long rating);

    void updateMovieRating(String title, Long rating);
}
