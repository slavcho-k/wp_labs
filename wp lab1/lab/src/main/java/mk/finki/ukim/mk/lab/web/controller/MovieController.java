package mk.finki.ukim.mk.lab.web.controller;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.service.MovieService;
import mk.finki.ukim.mk.lab.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final ProductionService productionService;

    @GetMapping("")
    public String getMoviesPage(Model model) {
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }

    @PostMapping("/add")
    public String saveMovie(
            @RequestParam String movieTitle,
            @RequestParam String summary,
            @RequestParam double rating,
            @RequestParam String productionName,
            @RequestParam(required = false) Long id
    ) {
        movieService.saveMovie(movieTitle, summary, rating, productionName, id);
        return "redirect:/movies";
    }

    @GetMapping("/add")
    public String addMoviePage(Model model) {
        model.addAttribute("productionHouses", productionService.findAll());
        return "addMovie";
    }

    @GetMapping("/edit/{movieId}")
    public String getEditMovieForm(@PathVariable Long movieId, Model model) {
        Movie movie = movieService.findMovieById(movieId);
        if (movie != null) {
            model.addAttribute("id", movieId);
            model.addAttribute("movie", movie);
            model.addAttribute("productionHouses", productionService.findAll());
            return "addMovie";
        }

        model.addAttribute("error", String.format("Movie with id %s doesnt exist", movieId));
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }

    @GetMapping("/delete/{movieId}")
    public String deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return "redirect:/movies";
    }
}
