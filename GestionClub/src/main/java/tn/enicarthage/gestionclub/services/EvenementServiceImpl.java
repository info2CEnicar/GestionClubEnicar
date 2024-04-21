package tn.enicarthage.gestionclub.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import tn.enicarthage.gestionclub.entities.Evenement;
import tn.enicarthage.gestionclub.entities.Materiel;
import tn.enicarthage.gestionclub.entities.Salle;
import tn.enicarthage.gestionclub.repositories.EvenementRepository;
import tn.enicarthage.gestionclub.repositories.MaterielRepository;
import tn.enicarthage.gestionclub.repositories.SalleRepository;

@Service
public class EvenementServiceImpl implements IEvenementService{
	
	@Autowired
    private EvenementRepository  evenementRepository;
	@Autowired
    private SalleRepository salleRepository;
	@Autowired
    private MaterielRepository materielRepository;
	
    public Evenement acceptEvent(Long eventId) {
    	markAsConsulted(eventId);
        return changeEventStatus(eventId, true);
    }

    public Evenement refuseEvent(Long eventId) {
    	markAsConsulted(eventId);
        return changeEventStatus(eventId, false);
    }

    public void markAsConsulted(Long eventId) {
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found: " + eventId));
        evenement.setConsulte(true);
        evenementRepository.save(evenement);
    }

    public Evenement changeEventStatus(Long eventId, boolean status) {
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found: " + eventId));
        evenement.setAccepted(status);
        return evenementRepository.save(evenement);
    }
    
    public Evenement addSallesToEvent(Long eventId, List<Long> salleIds) {
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found: " + eventId));
        List<Salle> sallesToAdd = salleRepository.findAllById(salleIds);
        evenement.getSalles().addAll(sallesToAdd); 
        return evenementRepository.save(evenement);
    }
    
    public Evenement addMaterielToEvent(Long eventId, Long materielId, int quantityDemanded) throws Exception {
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event not found: " + eventId));

        Materiel materiel = materielRepository.findById(materielId)
                .orElseThrow(() -> new EntityNotFoundException("Materiel not found: " + materielId));

        if (quantityDemanded > materiel.getQuantiteDisponible()) {
            throw new Exception("Requested quantity exceeds available stock.");
        }

        // Set the quantity demanded for this event
        materiel.setQuantiteDemande(quantityDemanded);
        evenement.getMateriels().add(materiel);

        return evenementRepository.save(evenement);
    }
}
