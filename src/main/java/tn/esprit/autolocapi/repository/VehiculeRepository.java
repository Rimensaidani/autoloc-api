package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocapi.domain.CategorieVehicule;
import tn.esprit.autolocapi.domain.StatutVehicule;
import tn.esprit.autolocapi.domain.Vehicule;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findByAgenceIdAgence(Long idAgence);

    List<Vehicule> findByStatut(StatutVehicule statut);

    List<Vehicule> findByCategorie(CategorieVehicule categorie);
}