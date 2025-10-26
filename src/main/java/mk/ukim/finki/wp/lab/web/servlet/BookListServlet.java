package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.BookService;
import mk.ukim.finki.wp.lab.model.Book;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", urlPatterns = "/")
public class BookListServlet extends HttpServlet {

    private SpringTemplateEngine templateEngine;
    private BookService bookService;

    @Override
    public void init() {
        // Fetch Spring beans from the application context because the container creates the servlet
        WebApplicationContext ctx =
                WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.templateEngine = ctx.getBean(SpringTemplateEngine.class);
        this.bookService = ctx.getBean(BookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String text = req.getParameter("text");
        Double rating = null;
        try {
            String r = req.getParameter("rating");
            if (r != null && !r.isBlank()) rating = Double.valueOf(r);
        } catch (Exception ignored) { /* keep rating as null if parsing fails */ }

        // Query books (all or filtered)
        List<Book> books = (text != null || rating != null)
                ? bookService.searchBooks(text, rating)
                : bookService.listAll();

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("books", books);
        context.setVariable("text", text);
        context.setVariable("rating", rating);

        resp.setContentType("text/html;charset=UTF-8");
        templateEngine.process("listBooks.html", context, resp.getWriter());
    }
}
