package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;

    private BigDecimal montantTotal;

    private boolean valide;

    // Un contrat correspond à une réservation
    @OneToOne
    @JoinColumn(name = "id_reservation")
    private Reservation reservation;

    // Un contrat peut avoir plusieurs paiements
    @OneToMany(
            mappedBy = "contrat",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Paiement> paiements;
}