package tn.enicarthage.organisation.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.organisation.Entities.Materiel;
import tn.enicarthage.organisation.Entities.Organisation;

import java.util.List;

public interface MaterielRepository extends JpaRepository<Materiel,Long> {
    List<Materiel> findByEtat(Boolean etat);
    List<Materiel> findByNomOrganisation(String nomOrganisation);
}
