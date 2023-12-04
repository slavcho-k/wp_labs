package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import mk.finki.ukim.mk.lab.service.TicketService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketService ticketService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public String addTicket(
            @RequestParam String movieTitle,
            @RequestParam int numTickets,
            @RequestParam(value = "dateCreated", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime
    ) {
        User user = userService.findUserByUsername("slavcho");
        if(dateTime == null) dateTime = LocalDateTime.now();
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUserId(user.getId());
        ticketService.addTicket(movieTitle, numTickets, shoppingCart, dateTime);
        return "redirect:/ticketOrder?movieTitle=" + movieTitle + "&numTickets=" +
                numTickets;
    }

    @GetMapping("/all")
    public String listAll(Model model) {
        model.addAttribute("tickets", ticketService.findAll());
        return "listTickets";
    }

    @GetMapping("")
    public String getTicketOrderPage(
            @RequestParam String movieTitle,
            @RequestParam int numTickets,
            HttpServletRequest request,
            Model model
    ) {
        User user = userService.findUserByUsername("slavcho");
        model.addAttribute("user", user.getPersonName().getName());
        model.addAttribute("ipAddr", request.getRemoteAddr());
        model.addAttribute("movieTitle", movieTitle);
        model.addAttribute("numOfTickets", numTickets);
        return "orderConfirmation";
    }

    @GetMapping("/edit-ticket/{id}")
    public String editTicketView(Model model, @PathVariable String id) {
        User user = userService.findUserByUsername("slavcho");
        model.addAttribute("id", id);
        model.addAttribute("ticket", ticketService.findById(Long.valueOf(id)));
        model.addAttribute("user", user);
        return "editTicket";
    }

    @PostMapping("/edit-ticket/{id}")
    public String editTicket(
            @RequestParam String movieTitle,
            @RequestParam int tickets,
            @PathVariable int id
    ) {
        User user = userService.findUserByUsername("slavcho");
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUserId(user.getId());
        ticketService.removeTicket((long) id);
        ticketService.addTicket(movieTitle, tickets, shoppingCart, null);
        return "redirect:/ticketOrder/all";
    }
}
