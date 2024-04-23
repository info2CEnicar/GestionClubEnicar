package tn.enicarthage.organisation.RestControllers;

import tn.enicarthage.organisation.Entities.Admin;
import tn.enicarthage.organisation.Entities.Bus;
import tn.enicarthage.organisation.Entities.Organisation;
import tn.enicarthage.organisation.Repository.BusRepository;
import tn.enicarthage.organisation.Repository.OrganisationRepository;
import tn.enicarthage.organisation.Services.AdminService;
import tn.enicarthage.organisation.Services.BusService;
import tn.enicarthage.organisation.Services.OrganisationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/demandeBus")
public class DemandeBusRestController {
    @Autowired
    BusService demandeBusService ;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private OrganisationRepository organisationRepository;
    @RequestMapping(method = RequestMethod.POST)

    public Bus ajoutdemandeBus(@RequestBody Bus demandeBus){
        return demandeBusService.ajouterDemandeBus(demandeBus);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Bus modifierDemandeBus(@PathVariable("id") Long id, @RequestBody Bus demandeBus){
    	Bus newDemande = demandeBusService.modifierDemandeBus(demandeBus);
        return newDemande;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Bus> afficherdemandeBus(){
        return demandeBusService.afficherDemandeBus();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void supprimerdemandeBus(@PathVariable("id") Long id){

        demandeBusService.supprimerById(id);
    }
    @GetMapping("/enattente")
    public List<Bus> getDemandesEnAttente() {
        return demandeBusService.getDemandesEnAttente();
    }

    @GetMapping("/acceptees")
    public List<Bus> getDemandesAcceptees() {
        return demandeBusService.getDemandesAcceptees();
    }

    @GetMapping("/refusees")
    public List<Bus> getDemandesRefusees() {
        return demandeBusService.getDemandesRefusees();
    }
    @PutMapping("/{id}/accepter")
    public Bus accepterDemande(@PathVariable Long id) {
        return demandeBusService.accepterDemandeBus(id);
    }

    @PutMapping("/{id}/refuser")
    public Bus refuserDemande(@PathVariable Long id) {
        return demandeBusService.refuserDemandeBus(id);
    }
    @GetMapping("/organisation/{organisationId}")
    public List<Bus> listerDemandesBusParClub(@PathVariable Long organisationId) {
        Organisation org = new Organisation();
        org.setId(organisationId);
        return demandeBusService.listerDemandesBusParClub(org.getNom());
    }

}
