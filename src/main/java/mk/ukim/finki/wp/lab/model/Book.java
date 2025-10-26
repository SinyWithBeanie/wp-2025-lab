package mk.ukim.finki.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor
public class Book {
    private String title;
    private String genre;
    private double averageRating;
}
