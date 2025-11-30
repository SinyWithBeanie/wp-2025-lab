package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String genre;

    private Double averageRating;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(nullable = false)
    private Integer likes = 0;

    public Book(String title, String genre, Double averageRating, Author author) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.author = author;
        this.likes = 0;
    }
}
