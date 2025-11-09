package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Optional<Book> save(String  title, String genre, Double averageRating, Long authorId) {
        Author author = authorRepository.findById(authorId).orElse(null);

        Book book = new Book(title, genre, averageRating, author);

        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, String title, String genre, Double averageRating, Long authorId) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            Author author = authorRepository.findById(authorId).orElse(null);

            Book book = existingBook.get();
            book.setTitle(title);
            book.setGenre(genre);
            book.setAverageRating(averageRating);
            book.setAuthor(author);

            return Optional.empty();
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
