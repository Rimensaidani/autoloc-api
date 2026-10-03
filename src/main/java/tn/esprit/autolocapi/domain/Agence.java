package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;

    @NotBlank
    String nom;

    String ville;
    String adresse;
    String telephone;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    List<Employe> employes;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    List<Vehicule> vehicules;
}