package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketService ticketService;

    @PostMapping("/add")
    public String addTicket(
            @RequestParam String movieTitle,
            @RequestParam int numTickets
    ) {
        ticketService.addTicket(0, "slavcho", movieTitle, numTickets);
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
        model.addAttribute("user", "slavcho");
        model.addAttribute("ipAddr", request.getRemoteAddr());
        model.addAttribute("movieTitle", movieTitle);
        model.addAttribute("numOfTickets", numTickets);
        return "orderConfirmation";
    }

    @GetMapping("/edit-ticket/{id}")
    public String editTicketView(Model model, @PathVariable String id) {
        model.addAttribute("id", id);
        model.addAttribute("ticket", ticketService.findById(Long.valueOf(id)));
        return "editTicket";
    }

    @PostMapping("/edit-ticket/{id}")
    public String editTicket(
            @RequestParam String movieTitle,
            @RequestParam int tickets,
            @RequestParam String client,
            @PathVariable long id
    ) {
        ticketService.addTicket(id, client, movieTitle, tickets);
        return "redirect:/ticketOrder/all";
    }
}
