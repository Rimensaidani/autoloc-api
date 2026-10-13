package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.domain.StatutReservation;
import tn.esprit.autolocapi.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation introuvable : " + id));
    }

    public List<Reservation> getByClient(Long idClient) {
        return reservationRepository.findByClientIdClient(idClient);
    }

    public List<Reservation> getByVehicule(Long idVehicule) {
        return reservationRepository.findByVehiculeIdVehicule(idVehicule);
    }

    public List<Reservation> getByStatut(StatutReservation statut) {
        return reservationRepository.findByStatut(statut);
    }

    public Reservation create(Reservation reservation) {
        if (reservation.getStatut() == null) {
            reservation.setStatut(StatutReservation.EN_ATTENTE);
        }
        return reservationRepository.save(reservation);
    }

    public Reservation update(Long id, Reservation reservation) {
        getById(id);
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
    }

    public void delete(Long id) {
        reservationRepository.delete(getById(id));
    }
}