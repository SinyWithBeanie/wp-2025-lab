package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.BookReservationService;
import mk.ukim.finki.wp.lab.model.BookReservation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "BookReservationServlet", urlPatterns = "/bookReservation")
public class BookReservationServlet extends HttpServlet {

    private SpringTemplateEngine templateEngine;
    private BookReservationService reservationService;

    @Override
    public void init() {
        WebApplicationContext ctx =
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.templateEngine = ctx.getBean(SpringTemplateEngine.class);
        this.reservationService = ctx.getBean(BookReservationService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String bookTitle = req.getParameter("bookTitle");
        String readerName = req.getParameter("readerName");
        String readerAddress = req.getParameter("readerAddress");
        int numCopies = Integer.parseInt(req.getParameter("numCopies"));

        String clientIp = req.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isBlank()) clientIp = req.getRemoteAddr();

        BookReservation saved =
                reservationService.placeReservation(bookTitle, readerName, readerAddress, numCopies);

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("reservation", saved);
        context.setVariable("clientIp", clientIp);

        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("reservationConfirmation.html", context, resp.getWriter());
    }
}
