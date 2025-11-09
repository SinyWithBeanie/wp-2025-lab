package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {

    public static List<Book> books = new ArrayList<>();
    public static List<BookReservation> reservations = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();

    @PostConstruct
    public void init(){
        Author author1 = new Author("Robert", "Martin", "USA", "Software engineer and author of Clean Code");
        Author author2 = new Author("J.R.R.", "Tolkien", "UK", "Author and philologist, creator of Middle-earth");
        Author author3 = new Author("George", "Orwell", "UK", "Novelist and journalist, author of 1984");

        authors.add(author1);
        authors.add(author2);
        authors.add(author3);

        books.add(new Book("Clean Code", "Programming", 4.8, author1));
        books.add(new Book("The Pragmatic Programmer", "Programming", 4.7, author1));
        books.add(new Book("Design Patterns", "Software Engineering", 4.5, author1));
        books.add(new Book("The Hobbit", "Fantasy", 4.6, author2));
        books.add(new Book("1984", "Dystopian", 4.4, author3));
        books.add(new Book("Dune", "Sci-Fi", 4.7, author2));
        books.add(new Book("Atomic Habits", "Self-help", 4.3, author3));
        books.add(new Book("Sapiens", "History", 4.4, author1));
        books.add(new Book("The Martian", "Sci-Fi", 4.2, author2));
        books.add(new Book("The Name of the Wind", "Fantasy", 4.5, author3));

        reservations.add(new BookReservation("test","test", "test",(long)10));
    }
}