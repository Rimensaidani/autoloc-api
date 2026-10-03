package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehicule;

    @NotBlank
    String immatriculation;

    String marque;
    String modele;

    @Enumerated(EnumType.STRING)
    CategorieVehicule categorie;

    @Positive
    BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agence", nullable = false)
    Agence agence;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "id_vehicule"),
            inverseJoinColumns = @JoinColumn(name = "id_equipement"))
    List<Equipement> equipements;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    List<Maintenance> maintenances;

    @OneToMany(mappedBy = "vehicule")
    List<Reservation> reservations;
}