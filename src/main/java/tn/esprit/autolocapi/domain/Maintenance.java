package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMaintenance;

    @NotNull
    LocalDate dateDebut;

    LocalDate dateFin;

    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule", nullable = false)
    Vehicule vehicule;
}