package tn.enicarthage.gestionclub.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.gestionclub.entities.Evenement;
import tn.enicarthage.gestionclub.entities.Materiel;
import tn.enicarthage.gestionclub.repositories.EvenementRepository;
import tn.enicarthage.gestionclub.repositories.MaterielRepository;

@Service
public class MaterielServiceImpl {
	@Autowired
    private MaterielRepository materielRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    public int calculateAvailableMaterial(Long materielId, Date date) {

        List<Evenement> eventsOnDate = evenementRepository.findByDateEvenement(date);

        int totalDemandedQuantity = eventsOnDate.stream()
            .flatMap(event -> event.getMateriels().stream())
            .filter(materiel -> materiel.getId().equals(materielId))
            .mapToInt(Materiel::getQuantiteDemande)
            .sum();

        Materiel materiel = materielRepository.findById(materielId)
                .orElseThrow(() -> new RuntimeException("Material not found: " + materielId));
        return materiel.getQuantiteDisponible() - totalDemandedQuantity;
    }
}
