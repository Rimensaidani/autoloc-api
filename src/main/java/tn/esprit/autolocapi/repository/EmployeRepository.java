package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.domain.RoleEmploye;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findByAgenceIdAgence(Long idAgence);

    List<Employe> findByRole(RoleEmploye role);
}