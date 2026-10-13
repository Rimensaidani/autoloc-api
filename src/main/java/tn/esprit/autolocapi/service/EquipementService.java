package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.repository.EquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementService {

    private final EquipementRepository equipementRepository;

    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }

    public Equipement getById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable : " + id));
    }

    public Equipement create(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    public Equipement update(Long id, Equipement equipement) {
        getById(id);
        equipement.setIdEquipement(id);
        return equipementRepository.save(equipement);
    }

    public void delete(Long id) {
        equipementRepository.delete(getById(id));
    }
}