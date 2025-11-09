package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {

    private final BookReservationService bookReservationService;

    public BookReservationController(BookReservationService bookReservationService) {
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String createReservation(
            @RequestParam String bookTitle,
            @RequestParam String readerName,
            @RequestParam String readerAddress,
            @RequestParam Integer numCopies,
            HttpServletRequest request,
            Model model) {

        String clientIp = request.getRemoteAddr();

        try {
            BookReservation reservation = bookReservationService.placeReservation(
                    bookTitle,
                    readerName,
                    readerAddress,
                    numCopies
            );

            model.addAttribute("readerName", readerName);
            model.addAttribute("clientIp", clientIp);
            model.addAttribute("bookTitle", bookTitle);
            model.addAttribute("numberOfCopies", numCopies);

            return "reservationConfirmation";
        } catch (Exception e) {
            return "redirect:/books?error=ReservationFailed";
        }
    }
}