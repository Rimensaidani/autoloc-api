package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;

    private String marque;

    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // Plusieurs véhicules appartiennent à une agence
    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;

    // Un véhicule possède plusieurs maintenances
    @OneToMany(mappedBy = "vehicule")
    private List<Maintenance> maintenances;

    // Un véhicule possède plusieurs équipements
    @OneToMany(mappedBy = "vehicule")
    private List<Equipement> equipements;

    // Un véhicule peut avoir plusieurs réservations
    @OneToMany(mappedBy = "vehicule")
    private List<Reservation> reservations;
}