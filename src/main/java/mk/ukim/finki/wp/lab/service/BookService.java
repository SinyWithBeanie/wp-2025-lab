package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
    Optional<Book> save(String title, String genre, Double averageRating, Long authorId);
    Optional<Book> findById(Long id);
    Optional<Book> update(Long id, String title, String genre, Double averageRating, Long authorId);
    void deleteById(Long id);
}
