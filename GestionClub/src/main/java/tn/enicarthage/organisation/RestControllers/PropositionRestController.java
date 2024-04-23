package tn.enicarthage.organisation.RestControllers;

import tn.enicarthage.organisation.Entities.Proposition;
import tn.enicarthage.organisation.Services.PropositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/proposition")
public class PropositionRestController {
    @Autowired
    PropositionService propService ;
    @RequestMapping(method = RequestMethod.POST)
    public Proposition ajouterProposition(@RequestBody Proposition proposition){
        return propService.ajouterProposition(proposition);

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public  Proposition modifierProposition(@PathVariable("id") Long id, @RequestBody Proposition proposition){
        Proposition propos = propService.modifierProposition(proposition);
        return propos;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Proposition> afficherProposition(){
        return propService.afficherProposition();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Proposition> getPropositionnById(@PathVariable("id") Long id){
        return propService.getPropositionnById(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void supprimerPropById(@PathVariable("id") Long id ){
        propService.supprimerPropById(id);
    }
}
