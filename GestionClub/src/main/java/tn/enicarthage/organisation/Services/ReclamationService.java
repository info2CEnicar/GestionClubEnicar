package tn.enicarthage.organisation.Services;

import java.util.List;
import java.util.Optional;

import tn.enicarthage.organisation.Entities.Reclamation;

public interface ReclamationService {
    public Reclamation ajouterReclamation (Reclamation rec);
    public Reclamation modifierReclamation(Reclamation rec);
    public List<Reclamation> afficherReclamation();
    public Optional<Reclamation> getReclamationById(Long id);
    public void supprimerRecById(Long id);
}
