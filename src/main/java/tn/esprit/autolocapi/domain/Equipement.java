package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    private String libelle;

    // Plusieurs équipements appartiennent à un véhicule
    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    private Vehicule vehicule;
}