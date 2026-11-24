package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Employe;

import java.util.List;

public interface IEmployeService {
    public Employe ajouterEmploye(Employe employe);
    public Employe modifierEmploye(Employe employe);
    public Employe getEmployeById(Long id);
    public List<Employe> getAllEmploye();
    public void supprimerEmployeById(Long id);

    Employe desaffecterEmploye(Long idEmploye);
    public Employe affectEmploye(Long idEmploye , Long idAgence);





}