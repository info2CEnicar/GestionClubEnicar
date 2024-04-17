package tn.enicarthage.gestionclub.services;

import java.util.Date;
import java.util.List;

import tn.enicarthage.gestionclub.entities.Salle;

public interface ISalleService {
	public List<Salle> getAvailableSalles(Date date);
}
