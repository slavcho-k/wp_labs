package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.repository.MovieRepository;
import mk.finki.ukim.mk.lab.repository.ProductionRepository;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text, Long rating) {
        return movieRepository.searchMovies(text, rating);
    }

    @Override
    public void saveMovie(String movieTtile, String summary, double rating, String productionName, Long id) {
        if (id != null) {
            movieRepository.removeMovieById(id);
            movieRepository.saveMovie(new Movie(movieTtile, summary, rating, productionRepository.findProductionByName(productionName)));
            return;
        }
        movieRepository.saveMovie(new Movie(movieTtile, summary, rating, productionRepository.findProductionByName(productionName)));
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.removeMovieById(movieId);
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }
}
