package tn.enicarthage.organisation.RestControllers;

import tn.enicarthage.organisation.Entities.*;
import tn.enicarthage.organisation.Services.MaterielService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/demandeMateriel")
public class DemandeMaterielRestController {
    @Autowired
    MaterielService MaterielService;
    @RequestMapping(method = RequestMethod.POST)

    public Materiel ajoutdemandeMateriel(@RequestBody Materiel demandeMateriel){
        return MaterielService.ajouterDemandeMateriel(demandeMateriel);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Materiel modifierDemandeMateriel(@PathVariable("id") Long id, @RequestBody Materiel demandeMateriel){
    	Materiel newDemande = MaterielService.modifierDemandeMateriel(demandeMateriel);
        return newDemande;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Materiel> afficherdemandeMateriel(){
        return MaterielService.afficherDemandeMateriel();
    }
    @RequestMapping(value = "/{id}",method=RequestMethod.DELETE)
    public void supprimerdemandeMateriel(@PathVariable("id") Long id){

    	MaterielService.supprimerById(id);
    }
    @GetMapping("/enattente")
    public List<Materiel> getDemandesEnAttente() {
        return MaterielService.getDemandesEnAttente();
    }

    @GetMapping("/acceptees")
    public List<Materiel> getDemandesAcceptees() {
        return MaterielService.getDemandesAcceptees();
    }

    @GetMapping("/refusees")
    public List<Materiel> getDemandesRefusees() {
        return MaterielService.getDemandesRefusees();
    }
    @PutMapping("/{id}/accepter")
    public Materiel accepterDemande(@PathVariable Long id) {
        return MaterielService.accepterDemandeMateriel(id);
    }

    @PutMapping("/{id}/refuser")
    public Materiel refuserDemande(@PathVariable Long id) {
        return MaterielService.refuserDemandeMateriel(id);
    }
    @GetMapping("/organisation/{organisationId}")
    public List<Materiel> listerDemandesMaterielParClub(@PathVariable Long organisationId) {
        Organisation org = new Organisation();
        org.setId(organisationId);
        return MaterielService.listerDemandesMaterielParClub(org.getNom());
    }
}
