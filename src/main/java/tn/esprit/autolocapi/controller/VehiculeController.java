package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.ajouterVehicule(vehicule);
    }
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule){
        return vehiculeService.modifierVehicule(vehicule);
    }
    @GetMapping("/getAllVehicules")
    public List<Vehicule> getAllVehicule(){
        return vehiculeService.getAllVehicule();
    }
    @GetMapping("/recupererVehicule/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id){
        return vehiculeService.getVehiculeById(id);
    }
    @DeleteMapping("/deleteVehiculeById/{id}")
    public void supprimerVehiculeById(@PathVariable Long id){
         vehiculeService.supprimerVehiculeById(id);
    }


    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule affecterEquipement(@PathVariable Long idVehicule,
                                       @PathVariable Long idEquipement) {
        return vehiculeService.affecterEquipement(idVehicule, idEquipement);
    }

    @PutMapping("/desaffecterEquipement/{idVehicule}/{idEquipement}")
    public Vehicule desaffecterEquipement(@PathVariable Long idVehicule,
                                          @PathVariable Long idEquipement) {
        return vehiculeService.desaffecterEquipement(idVehicule, idEquipement);
    }

}
