package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBookRepository implements BookRepository {

    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream()
                .filter(obj -> obj.getTitle().contains(text) && obj.getAverageRating() >= rating)
                .toList();
    }

    @Override
    public Optional<Book> save(Book book) {
        DataHolder.books.add(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return DataHolder.books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.books.removeIf(book -> book.getId().equals(id));
    }
}
