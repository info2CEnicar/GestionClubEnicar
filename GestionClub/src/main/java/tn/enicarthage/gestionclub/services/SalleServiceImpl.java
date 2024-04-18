package tn.enicarthage.gestionclub.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enicarthage.gestionclub.entities.Evenement;
import tn.enicarthage.gestionclub.entities.Salle;
import tn.enicarthage.gestionclub.repositories.EvenementRepository;
import tn.enicarthage.gestionclub.repositories.SalleRepository;

@Service
public class SalleServiceImpl implements ISalleService{

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    // Method to get available salles for a given date
    public List<Salle> getAvailableSalles(Date date) {
        // Fetch all events on the given date
        List<Evenement> eventsOnDate = evenementRepository.findByDateEvenement(date);
        
        // Collect all salle IDs from these events (assume all are unavailable)
        List<Long> unavailableSalleIds = eventsOnDate.stream()
            .flatMap(event -> event.getSalles().stream())
            .map(Salle::getId)
            .distinct()
            .collect(Collectors.toList());

        // Fetch all salles and remove the unavailable ones
        List<Salle> allSalles = salleRepository.findAll();
        return allSalles.stream()
            .filter(salle -> !unavailableSalleIds.contains(salle.getId()))
            .collect(Collectors.toList());
    }
}
