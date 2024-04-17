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

    public List<Salle> getAvailableSalles(Date date) {
    	
        List<Evenement> eventsOnDate = evenementRepository.findByDateEvenement(date);
        
        List<Long> unavailableSalleIds = eventsOnDate.stream()
            .flatMap(event -> event.getSalles().stream())
            .filter(salle -> !salle.getDisponibilite())
            .map(Salle::getId)
            .distinct()
            .collect(Collectors.toList());

        List<Salle> allSalles = salleRepository.findAll();
        return allSalles.stream()
            .filter(salle -> !unavailableSalleIds.contains(salle.getId()))
            .collect(Collectors.toList());
    }
}
