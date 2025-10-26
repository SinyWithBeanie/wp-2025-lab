package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Repository
public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        return DataHolder.books; // gets the "database" from DataHolder
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        String q = Optional.ofNullable(text).map(String::trim).map(String::toLowerCase).orElse("");
        double min = Optional.ofNullable(rating).orElse(Double.NEGATIVE_INFINITY);

        List<Book> result = new ArrayList<>();
        for (Book book : DataHolder.books) {
            String title = Optional.ofNullable(book.getTitle()).map(String::toLowerCase).orElse(null);
            if (title != null && title.contains(q) && book.getAverageRating() >= min) {
                result.add(book);
            }
        }
        return result;
    }
}
