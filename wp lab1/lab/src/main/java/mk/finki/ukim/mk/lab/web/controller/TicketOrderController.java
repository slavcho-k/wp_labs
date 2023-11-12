package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ticketOrder")
public class TicketOrderController {
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
}
