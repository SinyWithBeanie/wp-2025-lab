package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.repository.AuthorRepository;
import mk.ukim.finki.wp.lab.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        // Only populate if database is empty
        if (authorRepository.count() == 0) {
            Author author1 = authorRepository.save(new Author("Robert", "Martin", "USA", "Software engineer and author"));
            Author author2 = authorRepository.save(new Author("J.R.R.", "Tolkien", "UK", "Author and philologist"));
            Author author3 = authorRepository.save(new Author("George", "Orwell", "UK", "Novelist and journalist"));

            bookRepository.save(new Book("Clean Code", "Programming", 4.8, author1));
            bookRepository.save(new Book("The Pragmatic Programmer", "Programming", 4.7, author1));
            bookRepository.save(new Book("Design Patterns", "Software Engineering", 4.5, author1));
            bookRepository.save(new Book("The Hobbit", "Fantasy", 4.6, author2));
            bookRepository.save(new Book("The Lord of the Rings", "Fantasy", 4.9, author2));
            bookRepository.save(new Book("1984", "Dystopian", 4.7, author3));
            bookRepository.save(new Book("Animal Farm", "Political Fiction", 4.5, author3));
        }
    }
}