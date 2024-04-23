package tn.enicarthage.organisation.RestControllers;

import tn.enicarthage.organisation.Entities.*;
import tn.enicarthage.organisation.Services.SalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/demandeSalle")
public class DemandeSalleRestController {
    @Autowired
    SalleService demandeSalleService;
    @RequestMapping(value="/ajouter", method = RequestMethod.POST)

    public Salle ajoutdemandeSalle(@RequestBody Salle demandeSalle){
        return demandeSalleService.ajouterDemandeSalle(demandeSalle);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Salle modifierDemandeSalle(@PathVariable("id") Long id, @RequestBody Salle demandeSalle){
    	Salle newDemande = demandeSalleService.modifierDemandeSalle(demandeSalle);
        return newDemande;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Salle> afficherdemandeSalle(){
        return demandeSalleService.afficherDemandeSalle();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void supprimerdemandeSalle(@PathVariable("id") Long id){

        demandeSalleService.supprimerById(id);
    }
    @GetMapping("/enattente")
    public List<Salle> getDemandesEnAttente() {
        return demandeSalleService.getDemandesEnAttente();
    }

    @GetMapping("/acceptees")
    public List<Salle> getDemandesAcceptees() {
        return demandeSalleService.getDemandesAcceptees();
    }
    
    @GetMapping("/accepteesOrg")
    public List<Salle> getDemandesAccepteesOrg(@RequestParam String nomOrg) {
        return demandeSalleService.getDemandesAccepteesOrg(nomOrg);
    }

    @GetMapping("/refusees")
    public List<Salle> getDemandesRefusees() {
        return demandeSalleService.getDemandesRefusees();
    }
    @PutMapping("/{id}/accepter")
    public Salle accepterDemande(@PathVariable Long id) {
        return demandeSalleService.accepterDemandeSalle(id);
    }

    @PutMapping("/{id}/refuser")
    public Salle refuserDemande(@PathVariable Long id) {
        return demandeSalleService.refuserDemandeSalle(id);
    }
    @GetMapping("/organisation/{organisationId}")
    public List<Salle> listerDemandeSalleParClub(@PathVariable Long organisationId) {
        Organisation org = new Organisation();
        org.setId(organisationId);
        return demandeSalleService.listerDemandeSalleParClub(org.getNom());
    }
}
