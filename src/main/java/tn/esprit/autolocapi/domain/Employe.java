package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmploye;

    @NotBlank
    String nom;

    @NotBlank
    String prenom;

    @Enumerated(EnumType.STRING)
    RoleEmploye role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agence", nullable = false)
    Agence agence;
}