package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
    Optional<Book> save(Book book);
    Optional<Book> findById(Long id);
    void deleteById(Long id);
}
