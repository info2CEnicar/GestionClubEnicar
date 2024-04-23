package tn.enicarthage.organisation.Services;

import java.util.List;

import tn.enicarthage.organisation.Entities.Salle;

public interface SalleService {
	Salle ajouterDemandeSalle (Salle demandeSalle);
	Salle modifierDemandeSalle(Salle demandeSalle);
    List<Salle> afficherDemandeSalle();
    public List<Salle> getDemandesAccepteesOrg(String nomOrg);
    void supprimerById(Long id);
    List<Salle> getDemandesEnAttente();
    List<Salle> getDemandesAcceptees();
    List<Salle> getDemandesRefusees();
    Salle accepterDemandeSalle(Long id);
    Salle refuserDemandeSalle(Long id);
    List<Salle> listerDemandeSalleParClub(String nom_org);
}
