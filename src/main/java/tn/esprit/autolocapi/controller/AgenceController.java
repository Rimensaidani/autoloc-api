package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @GetMapping("/getAllAgences")
    public List<Agence> getAllAgence() {
        return agenceService.getAllAgence();
    }

    @GetMapping("/recupererAgence/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.getAgenceById(id);
    }

    @DeleteMapping("/deleteAgenceById/{id}")
    public void supprimerAgenceById(@PathVariable Long id) {
        agenceService.supprimerAgenceById(id);
    }
}