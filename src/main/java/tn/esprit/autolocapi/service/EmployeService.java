package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.domain.RoleEmploye;
import tn.esprit.autolocapi.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService {

    private final EmployeRepository employeRepository;

    public List<Employe> getAll() {
        return employeRepository.findAll();
    }

    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable : " + id));
    }

    public List<Employe> getByAgence(Long idAgence) {
        return employeRepository.findByAgenceIdAgence(idAgence);
    }

    public List<Employe> getByRole(RoleEmploye role) {
        return employeRepository.findByRole(role);
    }

    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    public Employe update(Long id, Employe employe) {
        getById(id);
        employe.setIdEmploye(id);
        return employeRepository.save(employe);
    }

    public void delete(Long id) {
        employeRepository.delete(getById(id));
    }
}