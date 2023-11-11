package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    String title;
    String summary;
    double rating;

    @Override
    public String toString() {
        return String.format("Title: %s, Summary: %s, Rating: %s", title, summary, rating);
    }
}

