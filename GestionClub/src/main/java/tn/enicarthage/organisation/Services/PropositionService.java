package tn.enicarthage.organisation.Services;

import java.util.List;
import java.util.Optional;

import tn.enicarthage.organisation.Entities.Proposition;

public interface PropositionService {
    public Proposition ajouterProposition (Proposition prop);
    public Proposition modifierProposition(Proposition prop);
    public List<Proposition> afficherProposition();
    public Optional<Proposition> getPropositionnById(Long id);
    public void supprimerPropById(Long id);
}
