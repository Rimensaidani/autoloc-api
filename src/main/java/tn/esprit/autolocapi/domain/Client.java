package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;

    @NotBlank
    String nom;

    @NotBlank
    String prenom;

    @Email
    String email;

    String telephone;
    String numPermis;
    LocalDate dateInscription;

    @OneToMany(mappedBy = "client")
    List<Reservation> reservations;

    @PrePersist
    void initDateInscription() {
        if (dateInscription == null) {
            dateInscription = LocalDate.now();
        }
    }
}