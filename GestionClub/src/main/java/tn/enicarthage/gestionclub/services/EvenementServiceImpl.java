package tn.enicarthage.gestionclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.gestionclub.entities.Evenement;
import tn.enicarthage.gestionclub.repositories.EvenementRepository;

@Service
public class EvenementServiceImpl implements IEvenementService{
	
	@Autowired
    private EvenementRepository  evenementRepository;

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
}
