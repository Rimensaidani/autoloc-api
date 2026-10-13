package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.CategorieVehicule;
import tn.esprit.autolocapi.domain.StatutVehicule;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.repository.VehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }

    public Vehicule getById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable : " + id));
    }

    public List<Vehicule> getByAgence(Long idAgence) {
        return vehiculeRepository.findByAgenceIdAgence(idAgence);
    }

    public List<Vehicule> getByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    public List<Vehicule> getByCategorie(CategorieVehicule categorie) {
        return vehiculeRepository.findByCategorie(categorie);
    }

    public Vehicule create(Vehicule vehicule) {
        if (vehicule.getStatut() == null) {
            vehicule.setStatut(StatutVehicule.DISPONIBLE);
        }
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule update(Long id, Vehicule vehicule) {
        getById(id);
        vehicule.setIdVehicule(id);
        return vehiculeRepository.save(vehicule);
    }

    public void delete(Long id) {
        vehiculeRepository.delete(getById(id));
    }
}