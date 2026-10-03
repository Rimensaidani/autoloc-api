package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPaiement;

    @Positive
    BigDecimal montant;

    LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    ModePaiement modePaiement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contrat", nullable = false)
    Contrat contrat;
}