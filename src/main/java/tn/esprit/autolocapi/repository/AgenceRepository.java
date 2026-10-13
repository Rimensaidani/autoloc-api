package tn.esprit.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autolocapi.domain.Agence;

import java.util.List;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {

    List<Agence> findByVille(String ville);
}