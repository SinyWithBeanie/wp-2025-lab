package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        if (bookTitle == null || bookTitle.isEmpty() ||
                readerName == null || readerName.isEmpty() ||
                readerAddress == null || readerAddress.isEmpty() ||
                numberOfCopies <= 0)
            throw new InvalidArgumentsException();

        BookReservation bookReservation = new BookReservation(
                bookTitle,
                readerName,
                readerAddress,
                numberOfCopies
        );

        return bookReservationRepository.save(bookReservation);

    }

    @Override
    public List<BookReservation> getReservationForBook(String bookTitle) {
        return bookReservationRepository.findByBookTitle(bookTitle);
    }
}
