package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.repository.PaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService {

    private final PaiementRepository paiementRepository;

    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }

    public Paiement getById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + id));
    }

    public List<Paiement> getByContrat(Long idContrat) {
        return paiementRepository.findByContratIdContrat(idContrat);
    }

    public Paiement create(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public Paiement update(Long id, Paiement paiement) {
        getById(id);
        paiement.setIdPaiement(id);
        return paiementRepository.save(paiement);
    }

    public void delete(Long id) {
        paiementRepository.delete(getById(id));
    }
}