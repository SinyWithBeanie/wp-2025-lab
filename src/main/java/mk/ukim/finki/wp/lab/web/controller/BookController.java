package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.wp.lab.model.Author;
import mk.ukim.finki.wp.lab.model.Book;
import mk.ukim.finki.wp.lab.service.AuthorService;
import mk.ukim.finki.wp.lab.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getBooksPage(@RequestParam(required = false) String error,
                               @RequestParam(required = false) String searchText,
                               @RequestParam(required = false) String searchRating,
                               HttpSession session,
                               Model model) {

        // Parse rating safely (maybe null or empty)
        Double rating = null;
        if (searchRating != null && !searchRating.isEmpty()) {
            try {
                rating = Double.parseDouble(searchRating);
            } catch (NumberFormatException ex) {
                error = "Invalid rating value.";
            }
        }

        List<Book> books;
        if ((searchText != null && !searchText.isEmpty()) || rating != null) {
            books = bookService.searchBooks(searchText, rating);
        } else {
            books = bookService.listAll();
        }

        model.addAttribute("books", books);

        // Keep search values so they stay in the form
        model.addAttribute("searchText", searchText);
        model.addAttribute("searchRating", searchRating);

        // Likes stored per session (per user)
        @SuppressWarnings("unchecked")
        Set<Long> likedBooks = (Set<Long>) session.getAttribute("likedBooks");
        if (likedBooks == null) {
            likedBooks = new HashSet<>();
        }
        model.addAttribute("likedBooks", likedBooks);

        // Error handling
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        return "listBooks";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "book-form";
    }

    @GetMapping("/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        Optional<Book> bookOpt = bookService.findById(id);
        if (bookOpt.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Book not found");
            return "redirect:/books";
        }

        Book book = bookOpt.get();
        List<Author> authors = authorService.findAll();
        model.addAttribute("book", book);
        model.addAttribute("authors", authors);
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        bookService.save(title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {

        bookService.update(bookId, title, genre, averageRating, authorId);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @PostMapping("/like/{id}")
    public String likeBook(@PathVariable Long id, HttpSession session) {
        @SuppressWarnings("unchecked")
        Set<Long> likedBooks = (Set<Long>) session.getAttribute("likedBooks");
        if (likedBooks == null) {
            likedBooks = new HashSet<>();
        }

        if (!likedBooks.contains(id)) {
            Book book = bookService.findById(id).orElse(null);
            if (book != null) {
                book.setLikes(book.getLikes() + 1);
                bookService.update(
                        book.getId(),
                        book.getTitle(),
                        book.getGenre(),
                        book.getAverageRating(),
                        book.getAuthor().getId()
                );
                likedBooks.add(id);
                session.setAttribute("likedBooks", likedBooks);
            }
        }

        return "redirect:/books";
    }
}
