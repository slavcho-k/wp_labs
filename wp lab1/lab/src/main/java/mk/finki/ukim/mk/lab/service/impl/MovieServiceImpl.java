package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;


    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text, Long rating) {
        return movieRepository.searchMovies(text, rating);
    }

    @Override
    public void updateMovieRating(String title, Long rating) {
        Optional<Movie> movie = movieRepository.getMovieByTitle(title);
        if(movie.isPresent()) {
            movie.get().setRating((movie.get().getRating() + rating) / 2);
            movieRepository.deleteMovieByName(movie.get().getTitle());
            movieRepository.addMovie(movie.get());
        }
    }
}
