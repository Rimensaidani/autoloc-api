package tn.esprit.autolocapi.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.repository.MaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : " + id));
    }

    public List<Maintenance> getByVehicule(Long idVehicule) {
        return maintenanceRepository.findByVehiculeIdVehicule(idVehicule);
    }

    public Maintenance create(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public Maintenance update(Long id, Maintenance maintenance) {
        getById(id);
        maintenance.setIdMaintenance(id);
        return maintenanceRepository.save(maintenance);
    }

    public void delete(Long id) {
        maintenanceRepository.delete(getById(id));
    }
}