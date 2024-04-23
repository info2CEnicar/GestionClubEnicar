package tn.enicarthage.organisation.Services;

import tn.enicarthage.organisation.Entities.Bus;
import tn.enicarthage.organisation.Entities.Organisation;
import tn.enicarthage.organisation.Exceptions.ResourceNotFoundException;
import tn.enicarthage.organisation.Repository.BusRepository;
import tn.enicarthage.organisation.Repository.OrganisationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BusServiceImpl implements BusService{
    @Autowired
    BusRepository busRepository;
    @Autowired
    OrganisationRepository organisationRepository;
    @Override
    public Bus ajouterDemandeBus(Bus demandeBus) {

        Bus demande = new Bus();
        demande.setDestination(demandeBus.getDestination());
        demande.setDateDep(demandeBus.getDateDep());
        demande.setDateArr(demandeBus.getDateArr());
        demande.setHeureDep(demandeBus.getHeureDep());
        demande.setHeureArr(demandeBus.getHeureArr());
        demande.setRaison(demandeBus.getRaison());
        demande.setNomOrganisation(demandeBus.getNomOrganisation());
        return busRepository.save(demande);
    }

    @Override
    public Bus modifierDemandeBus(Bus demandeBus) {
        return busRepository.save(demandeBus);
    }

    @Override
    public List<Bus> afficherDemandeBus() {
        return busRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
    	busRepository.deleteById(id);
    }

    @Override
    public List<Bus> getDemandesEnAttente() {
        return busRepository.findByAcceptee(null);
    }

    @Override
    public List<Bus> getDemandesAcceptees() {
        return busRepository.findByAcceptee(true);
    }

    @Override
    public List<Bus> getDemandesRefusees() {
        return busRepository.findByAcceptee(false);
    }

    @Override
    public Bus accepterDemandeBus(Long id) {
    	Bus demandeBus = busRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeBus.setAcceptee(true);
        return busRepository.save(demandeBus);
    }

    @Override
    public Bus refuserDemandeBus(Long id) {
    	Bus demandeBus = busRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Demande non trouvée"));
        demandeBus.setAcceptee(false);
        return busRepository.save(demandeBus);
    }

    @Override
    public List<Bus> listerDemandesBusParClub(String nom_org) {
        return busRepository.findByNomOrganisation(nom_org);
    }
}
