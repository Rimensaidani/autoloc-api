package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;

    @NotNull
    LocalDate dateDebut;

    @NotNull
    LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    StatutReservation statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule", nullable = false)
    Vehicule vehicule;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    Contrat contrat;
}