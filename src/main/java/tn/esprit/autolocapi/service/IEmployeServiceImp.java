package tn.esprit.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.repository.AgenceRepository;
import tn.esprit.autolocapi.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceImp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public void supprimerEmployeById(Long id) {
        employeRepository.deleteById(id);
    }

    public Employe desaffecterEmploye(Long idEmploye){
        Employe e = employeRepository.findById(idEmploye).get();
        //desaffectation a partir de l'entite parent
        e.setAgence(null);
        //sauvegarder de l'employe(apres modification(desaffectation
        return employeRepository.save(e);
    }

    @Override
    public Employe affectEmploye(Long idEmploye, Long idAgence) {
       Employe e = employeRepository.findById(idEmploye).get();
       Agence a = agenceRepository.findById(idAgence).get();
       e.setAgence(a);
       return employeRepository.save(e);

    }


}