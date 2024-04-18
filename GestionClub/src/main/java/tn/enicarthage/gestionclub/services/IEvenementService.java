package tn.enicarthage.gestionclub.services;

import java.util.List;

import tn.enicarthage.gestionclub.entities.Evenement;

public interface IEvenementService {
	public Evenement acceptEvent(Long eventId);
	public Evenement refuseEvent(Long eventId);
	public void markAsConsulted(Long eventId);
	public Evenement changeEventStatus(Long eventId, boolean status); 
	public Evenement addSallesToEvent(Long eventId, List<Long> salleIds);
	public Evenement addMaterielToEvent(Long eventId, Long materielId, int quantityDemanded) throws Exception;
}
