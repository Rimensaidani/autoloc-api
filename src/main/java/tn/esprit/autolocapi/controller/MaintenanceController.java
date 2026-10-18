package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping("/getAllMaintenances")
    public List<Maintenance> getAllMaintenance() {
        return maintenanceService.getAllMaintenance();
    }

    @GetMapping("/recupererMaintenance/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.getMaintenanceById(id);
    }

    @DeleteMapping("/deleteMaintenanceById/{id}")
    public void supprimerMaintenanceById(@PathVariable Long id) {
        maintenanceService.supprimerMaintenanceById(id);
    }
}