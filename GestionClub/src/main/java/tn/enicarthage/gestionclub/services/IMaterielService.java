package tn.enicarthage.gestionclub.services;

import java.util.Date;

public interface IMaterielService {
	public int calculateAvailableMaterial(Long materielId, Date date);
}
