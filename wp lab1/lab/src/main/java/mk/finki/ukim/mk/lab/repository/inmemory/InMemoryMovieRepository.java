//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
//import mk.finki.ukim.mk.lab.model.Movie;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InMemoryMovieRepository {
//
//    public List<Movie> findAll() {
//        return DataHolder.movieList;
//    }
//
//    public List<Movie> searchMovies(String text, Long rating) {
//        return DataHolder.movieList.stream()
//                .filter(m -> {
//                    if (text != null && rating != null) {
//                        return m.getTitle().toLowerCase().contains(text.toLowerCase()) && m.getRating() >= rating;
//                    } else if (text != null) {
//                        return m.getTitle().toLowerCase().contains(text.toLowerCase());
//                    } else {
//                        return m.getRating() >= rating;
//                    }
//                })
//                .toList();
//    }
//
//    public Movie findMovieById(Long id) {
//        return DataHolder.movieList.stream()
//                .filter(m -> m.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void removeMovieById(Long id) {
//        Optional<Movie> movie = DataHolder.movieList.stream().
//                filter(m -> m.getId().equals(id))
//                .findFirst();
//
//        movie.ifPresent(value -> DataHolder.movieList.remove(value));
//    }
//
//    public void saveMovie(Movie movie) {
//        Optional<Movie> movieOptional = DataHolder.movieList.stream()
//                .filter(m -> m.getId().equals(movie.getId()))
//                .findFirst();
//
//        if (movieOptional.isEmpty()) {
//            DataHolder.movieList.add(movie);
//        }
//    }
//
//}
