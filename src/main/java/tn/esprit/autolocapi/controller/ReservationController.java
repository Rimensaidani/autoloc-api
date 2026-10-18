package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/recupererReservation/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @DeleteMapping("/deleteReservationById/{id}")
    public void supprimerReservationById(@PathVariable Long id) {
        reservationService.supprimerReservationById(id);
    }
}