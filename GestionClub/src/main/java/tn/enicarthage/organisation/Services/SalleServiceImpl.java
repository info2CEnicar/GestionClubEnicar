package tn.enicarthage.organisation.Services;

import tn.enicarthage.organisation.Entities.Organisation;
import tn.enicarthage.organisation.Entities.Salle;
import tn.enicarthage.organisation.Exceptions.ResourceNotFoundException;
import tn.enicarthage.organisation.Repository.OrganisationRepository;
import tn.enicarthage.organisation.Repository.SalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SalleServiceImpl implements SalleService{
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    OrganisationRepository organisationRepository;
    @Override
    public Salle ajouterDemandeSalle(Salle demandeSalle) {
    	Salle demande = new Salle();
        demande.setNumSalle(demandeSalle.getNumSalle());
        demande.setBatiment(demandeSalle.getBatiment());
        demande.setDate(demandeSalle.getDate());
        demande.setTemps(demandeSalle.getTemps());
        demande.setDuree(demandeSalle.getDuree());
        demande.setRaison(demandeSalle.getRaison());
        demande.setNomOrganisation(demandeSalle.getNomOrganisation());
        System.out.println("tessssssssst");
        return salleRepository.save(demande);
    }

    @Override
    public Salle modifierDemandeSalle(Salle demandeSalle) {
        return salleRepository.save(demandeSalle);
    }

    @Override
    public List<Salle> afficherDemandeSalle() {
        return salleRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
    	salleRepository.deleteById(id);
    }

    @Override
    public List<Salle> getDemandesEnAttente() {
        return salleRepository.findByEtat(null);
    }

    @Override
    public List<Salle> getDemandesAcceptees() {
        return salleRepository.findByEtat(true);
    }
    
    @Override
    public List<Salle> getDemandesAccepteesOrg(String nomOrg) {
        return salleRepository.findByEtatAndNomOrganisation(true, nomOrg);
    }
    @Override
    public List<Salle> getDemandesRefusees() {
        return salleRepository.findByEtat(false);
    }

    @Override
    public Salle accepterDemandeSalle(Long id) {
    	Salle demandeSalle = salleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeSalle.setEtat(true);
        return salleRepository.save(demandeSalle);
    }

    @Override
    public Salle refuserDemandeSalle(Long id) {
    	Salle demandeSalle = salleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeSalle.setEtat(false);
        return salleRepository.save(demandeSalle);
    }

    @Override
    public List<Salle> listerDemandeSalleParClub(String nom_org) {
        return salleRepository.findByNomOrganisation(nom_org);
    }
}
