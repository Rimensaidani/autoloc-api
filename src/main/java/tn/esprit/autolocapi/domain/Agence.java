package tn.esprit.autolocapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnore
    List<Employe> employes;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Vehicule> vehicules;
}