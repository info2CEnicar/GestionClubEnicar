package tn.enicarthage.organisation.Services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.enicarthage.organisation.Entities.Admin;
import tn.enicarthage.organisation.Entities.Bus;
import tn.enicarthage.organisation.Entities.Organisation;

import java.util.List;

public interface BusService {
	Bus ajouterDemandeBus (Bus demandeBus);
	Bus modifierDemandeBus(Bus demandeBus);
    List<Bus> afficherDemandeBus();
    void supprimerById(Long id);
    List<Bus> getDemandesEnAttente();
    List<Bus> getDemandesAcceptees();
    List<Bus> getDemandesRefusees();
    Bus accepterDemandeBus(Long id);
    Bus refuserDemandeBus(Long id);
    List<Bus> listerDemandesBusParClub(String nom_org);

}
