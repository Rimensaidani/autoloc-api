package tn.esprit.autolocapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEquipement;

    @NotBlank
    String libelle;
    @JsonIgnore
    @ManyToMany(mappedBy = "equipements", fetch = FetchType.LAZY)
    List<Vehicule> vehicules;
}