package tn.esprit.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
@Tag(name="gestion des contrats", description = "Crud")
public class ContratController {
    private final IContratService contratService;
@Operation(summary = "ajouter un contrat")
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrat() {
        return contratService.getAllContrat();
    }

    @GetMapping("/recupererContrat/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @DeleteMapping("/deleteContratById/{id}")
    public void supprimerContratById(@PathVariable Long id) {
        contratService.supprimerContratById(id);
    }
}