package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autolocapi.domain.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}