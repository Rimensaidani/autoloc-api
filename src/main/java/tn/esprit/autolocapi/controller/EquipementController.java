package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {
    private final IEquipementService equipementService;

    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping("/getAllEquipements")
    public List<Equipement> getAllEquipement() {
        return equipementService.getAllEquipement();
    }

    @GetMapping("/recupererEquipement/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.getEquipementById(id);
    }

    @DeleteMapping("/deleteEquipementById/{id}")
    public void supprimerEquipementById(@PathVariable Long id) {
        equipementService.supprimerEquipementById(id);
    }
}