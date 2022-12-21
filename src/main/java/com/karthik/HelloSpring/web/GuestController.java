package com.karthik.HelloSpring.web;

import com.karthik.HelloSpring.business.ReservationService;
import com.karthik.HelloSpring.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final ReservationService reservationService;
    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<Guest> guests = this.reservationService.getGuests();
        model.addAttribute("guests", guests);
        return "hotel-guests";
    }
}
