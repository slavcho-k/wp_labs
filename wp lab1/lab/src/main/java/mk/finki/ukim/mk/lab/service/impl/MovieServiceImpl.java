package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import mk.finki.ukim.mk.lab.repository.jpa.MovieRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ProductionRepository;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll().stream().toList();
    }

    @Override
    public List<Movie> searchMovies(String text, Long rating) {
        //TODO search movies
        return null;
    }

    @Override
    public void saveMovie(String movieTtile, String summary, double rating, String productionName, Long id) {
        Optional<Production> productionOptional = productionRepository.findByName(productionName);
        if (productionOptional.isPresent()) {
            if (id != null) {
                movieRepository.delete(movieRepository.findById(id).get());
                movieRepository.save((new Movie(movieTtile, summary, rating, productionOptional.get())));
                return;
            }
            movieRepository.save(new Movie(movieTtile, summary, rating, productionOptional.get()));
        }
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    @Override
    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
