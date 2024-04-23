package tn.enicarthage.organisation.Services;

import tn.enicarthage.organisation.Entities.Materiel;
import tn.enicarthage.organisation.Entities.Organisation;
import tn.enicarthage.organisation.Exceptions.ResourceNotFoundException;
import tn.enicarthage.organisation.Repository.MaterielRepository;
import tn.enicarthage.organisation.Repository.OrganisationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class MaterielServiceImpl implements MaterielService {
    @Autowired
    MaterielRepository demandeMaterielRepository;
    @Autowired
    OrganisationRepository organisationRepository;
    @Override
    public Materiel ajouterDemandeMateriel(Materiel demandeMateriel) {
    	Materiel demande = new Materiel();
        demande.setMateriel(demandeMateriel.getMateriel());
        demande.setDate(demandeMateriel.getDate());
        demande.setTemps(demandeMateriel.getTemps());
        demande.setDuree(demandeMateriel.getDuree());
        demande.setQuantite(demandeMateriel.getQuantite());
        demande.setRaison(demandeMateriel.getRaison());
        demande.setNomOrganisation(demandeMateriel.getNomOrganisation());
        return demandeMaterielRepository.save(demande);
    }

    @Override
    public Materiel modifierDemandeMateriel(Materiel demandeMateriel) {
        return demandeMaterielRepository.save(demandeMateriel);
    }

    @Override
    public List<Materiel> afficherDemandeMateriel() {
        return demandeMaterielRepository.findAll();

    }

    @Override
    public void supprimerById(Long id) {
        demandeMaterielRepository.deleteById(id);
    }

    @Override
    public List<Materiel> getDemandesEnAttente() {
        return demandeMaterielRepository.findByEtat(null);
    }

    @Override
    public List<Materiel> getDemandesAcceptees() {
        return demandeMaterielRepository.findByEtat(true);
    }

    @Override
    public List<Materiel> getDemandesRefusees() {
        return demandeMaterielRepository.findByEtat(false);
    }

    @Override
    public Materiel accepterDemandeMateriel(Long id) {
    	Materiel demandeMateriel = demandeMaterielRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeMateriel.setEtat(true);
        return demandeMaterielRepository.save(demandeMateriel);
    }

    @Override
    public Materiel refuserDemandeMateriel(Long id) {
    	Materiel demandeMateriel = demandeMaterielRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeMateriel.setEtat(false);
        return demandeMaterielRepository.save(demandeMateriel);
    }

    @Override
    public List<Materiel> listerDemandesMaterielParClub(String nom_org) {
        return demandeMaterielRepository.findByNomOrganisation(nom_org);
    }
}
