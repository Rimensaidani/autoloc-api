package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // Une réservation concerne un seul véhicule
    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;

    // Une réservation appartient à un seul client
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // Une réservation possède un contrat
    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}