package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceService {

    private final AgenceRepository agenceRepository;

    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }

    public Agence getById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + id));
    }

    public List<Agence> getByVille(String ville) {
        return agenceRepository.findByVille(ville);
    }

    public Agence create(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Agence update(Long id, Agence agence) {
        getById(id);
        agence.setIdAgence(id);
        return agenceRepository.save(agence);
    }

    public void delete(Long id) {
        agenceRepository.delete(getById(id));
    }
}