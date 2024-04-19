package tn.enicarthage.gestionclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import tn.enicarthage.gestionclub.entities.Admin;
import tn.enicarthage.gestionclub.entities.ResponsableClub;
import tn.enicarthage.gestionclub.entities.Utilisateur;
import tn.enicarthage.gestionclub.repositories.UtilisteurRepository;

@Service
public class AuthentificationServiceImpl implements IAuthentificationService{
	
	@Autowired
    private UtilisteurRepository utilisateurRepository;

    public String authenticateUser(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmailAndPassword(email, password);
        if (utilisateur == null) {
            throw new EntityNotFoundException("User not found");
        }
        if (utilisateur instanceof Admin) {
            return "Admin";
        } else if (utilisateur instanceof ResponsableClub) {
            return "ResponsableClub";
        } else {
            return "Unknown"; // or handle other types if any
        }
    }
}
