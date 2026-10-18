package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @GetMapping("/getAllPaiements")
    public List<Paiement> getAllPaiement() {
        return paiementService.getAllPaiement();
    }

    @GetMapping("/recupererPaiement/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.getPaiementById(id);
    }

    @DeleteMapping("/deletePaiementById/{id}")
    public void supprimerPaiementById(@PathVariable Long id) {
        paiementService.supprimerPaiementById(id);
    }
}