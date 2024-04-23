package tn.enicarthage.organisation.Services;



import java.util.List;

import tn.enicarthage.organisation.Entities.Materiel;

public interface MaterielService {
	Materiel ajouterDemandeMateriel (Materiel demandeMaterielDto);
	Materiel modifierDemandeMateriel(Materiel demandeMateriel);
    List<Materiel> afficherDemandeMateriel();
    void supprimerById(Long id);
    List<Materiel> getDemandesEnAttente();
    List<Materiel> getDemandesAcceptees();
    List<Materiel> getDemandesRefusees();
    Materiel accepterDemandeMateriel(Long id);
    Materiel refuserDemandeMateriel(Long id);
    List<Materiel> listerDemandesMaterielParClub(String nom_org);
}
