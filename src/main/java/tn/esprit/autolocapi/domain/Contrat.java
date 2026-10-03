package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idContrat;

    LocalDate dateSignature;

    @Positive
    BigDecimal montantTotal;

    boolean valide;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reservation", nullable = false, unique = true)
    Reservation reservation;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Paiement> paiements;
}