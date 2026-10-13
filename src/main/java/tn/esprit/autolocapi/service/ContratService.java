package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.repository.ContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService {

    private final ContratRepository contratRepository;

    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }

    public Contrat getById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + id));
    }

    public Contrat getByReservation(Long idReservation) {
        return contratRepository.findByReservationIdReservation(idReservation)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun contrat pour la réservation : " + idReservation));
    }

    public Contrat create(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    public Contrat update(Long id, Contrat contrat) {
        getById(id);
        contrat.setIdContrat(id);
        return contratRepository.save(contrat);
    }

    public void delete(Long id) {
        contratRepository.delete(getById(id));
    }
}