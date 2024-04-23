package tn.enicarthage.organisation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.organisation.Entities.Salle;

public interface SalleRepository extends JpaRepository<Salle,Long> {
    List<Salle> findByEtat(Boolean etat);
    List<Salle> findByNomOrganisation(String nomOrganisation);
    List<Salle> findByEtatAndNomOrganisation(Boolean etat, String nomOrg);
}
