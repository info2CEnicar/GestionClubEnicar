package tn.enicarthage.organisation.Services;

import java.util.List;
import java.util.Optional;

import tn.enicarthage.organisation.Entities.Admin;

public interface AdminService {
    Admin ajouterAdmin (Admin admin);
    Admin modifierAdmin(Admin admin);
    // je vais afficher la liste des Organisations dans une liste
    List<Admin> afficherAdmin();
    void supprimerById(Long id);
    //
    Optional<Admin> getAdminById(Long id);
}
