package tn.enicarthage.gestionclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import tn.enicarthage.gestionclub.entities.Club;
import tn.enicarthage.gestionclub.entities.ResponsableClub;
import tn.enicarthage.gestionclub.repositories.ClubRepository;
import tn.enicarthage.gestionclub.repositories.ResponsableClubRepository;

@Service
public class ResponsableClubServiceImpl implements IResponsableClubService{
	
	@Autowired
    private ResponsableClubRepository responsableClubRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Transactional
    public ResponsableClub createOrUpdateResponsableClubWithClubInfo( 
            String userName, String email, String password,
            String clubName, String clubDescription, String clubType, String clubImage,
            int responsableClubNumTel) {

        Club club = new Club();
        club.setNom(clubName);
        club.setDescription(clubDescription);
        club.setType(clubType);
        club.setImage(clubImage);
        club = clubRepository.save(club);

        ResponsableClub responsableClub = new ResponsableClub();

        responsableClub.setUserName(userName);
        responsableClub.setEmail(email);
        responsableClub.setPassword(password);
        responsableClub.setNumTel(responsableClubNumTel);
        responsableClub.setClub(club);
        
        return responsableClubRepository.save(responsableClub);
    }
}
