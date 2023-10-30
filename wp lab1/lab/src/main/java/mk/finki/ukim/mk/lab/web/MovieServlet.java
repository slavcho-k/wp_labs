package mk.finki.ukim.mk.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "")
@RequiredArgsConstructor
public class MovieServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext webContext = new WebContext(webExchange);

        System.out.println("title" + req.getParameter("title"));
        System.out.println("rating" + req.getParameter("rating"));
        if (req.getParameter("title") == null && req.getParameter("rating") == null) {
            System.out.println("VLEZE");
            webContext.setVariable("movies", movieService.listAll());
        } else {
            System.out.println("VLEZE2");
            webContext.setVariable("movies", movieService.searchMovies(req.getParameter("title"), Long.valueOf(req.getParameter("rating"))));
        }

        springTemplateEngine.process("listMovies.html", webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String movieTitle = req.getParameter("movieTitle");
        long numOfTickets = Long.parseLong(req.getParameter("numTickets"));

        if (movieTitle == null) {
            throw new ServletException("Movie title is required.");
        }

        resp.sendRedirect("/ticketOrder?title=" + movieTitle + "&tickets=" + numOfTickets);
    }
}
