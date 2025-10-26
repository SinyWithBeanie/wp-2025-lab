package mk.ukim.finki.wp.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookReservationServiceImpl implements BookReservationService {

    private final BookReservationRepository bookReservationRepository;

    @Override
    public BookReservation placeReservation (String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        return bookReservationRepository.save(new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies));
    }
}
