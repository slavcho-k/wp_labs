package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private String summary;
    private double rating;
    private Production production;

    public Movie(String title, String summary, double rating, Production production) {
        this.id = (long) (Math.random() * 10000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }

    @Override
    public String toString() {
        return String.format("Title: %s, Summary: %s, Rating: %s Production: %s", title, summary, rating, production.getName());
    }
}

