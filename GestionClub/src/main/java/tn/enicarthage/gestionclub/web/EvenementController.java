package tn.enicarthage.gestionclub.web;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import tn.enicarthage.gestionclub.entities.Evenement;
import tn.enicarthage.gestionclub.services.IEvenementService;

@RestController
@RequestMapping("/evenementAdmin")
public class EvenementController {

    @Autowired
    private IEvenementService evenementService;

    @PutMapping("/{eventId}/accept")
    public ResponseEntity<Evenement> acceptEvent(@PathVariable Long eventId) {
        Evenement event = evenementService.acceptEvent(eventId);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/{eventId}/refuse")
    public ResponseEntity<Evenement> refuseEvent(@PathVariable Long eventId) {
        Evenement event = evenementService.refuseEvent(eventId);
        return ResponseEntity.ok(event);
    }
    
    @PostMapping("/{eventId}/addSalles")
    public ResponseEntity<Evenement> addSallesToEvent(@PathVariable Long eventId, @RequestBody List<Long> salleIds) {
        Evenement updatedEvent = evenementService.addSallesToEvent(eventId, salleIds);
        return ResponseEntity.ok(updatedEvent);
    }
    
 // Endpoint to add materiel to an existing event
    @PostMapping("/{eventId}/addMateriel")
    public ResponseEntity<?> addMaterielToEvent(@PathVariable Long eventId, @RequestParam Long materielId, @RequestParam int quantityDemanded) {
        try {
            Evenement updatedEvent = evenementService.addMaterielToEvent(eventId, materielId, quantityDemanded);
            return ResponseEntity.ok(updatedEvent);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    // Mark an event as consulted
    /*@PutMapping("/{eventId}/consult")
    public void consultEvent(@PathVariable Long eventId) {
        evenementService.markAsConsulted(eventId);
    }*/
}
