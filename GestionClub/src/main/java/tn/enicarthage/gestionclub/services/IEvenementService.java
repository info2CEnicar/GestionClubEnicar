package tn.enicarthage.gestionclub.services;

import tn.enicarthage.gestionclub.entities.Evenement;

public interface IEvenementService {
	public Evenement acceptEvent(Long eventId);
	public Evenement refuseEvent(Long eventId);
	public void markAsConsulted(Long eventId);
	public Evenement changeEventStatus(Long eventId, boolean status); 
}
