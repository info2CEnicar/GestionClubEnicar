package tn.enicarthage.gestionclub.services;

import tn.enicarthage.gestionclub.entities.ResponsableClub;

public interface IResponsableClubService {
	
	public ResponsableClub createOrUpdateResponsableClubWithClubInfo( 
            String userName, String email, String password,
            String clubName, String clubDescription, String clubType, String clubImage,
            int responsableClubNumTel);
}	
