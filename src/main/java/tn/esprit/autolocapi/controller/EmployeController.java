package tn.esprit.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {
    private final IEmployeService employeService;

    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @GetMapping("/getAllEmployes")
    public List<Employe> getAllEmploye() {
        return employeService.getAllEmploye();
    }

    @GetMapping("/recupererEmploye/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    @DeleteMapping("/deleteEmployeById/{id}")
    public void supprimerEmployeById(@PathVariable Long id) {
        employeService.supprimerEmployeById(id);
    }

    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);

    }
    @PutMapping("/affecterEmploye/{idEmploye},{idAgence}")
    public Employe affectAgence(@PathVariable Long idEmploye ,@PathVariable Long idAgence){
        return employeService.affectEmploye(idEmploye, idAgence);
    }

}


