package tn.enicarthage.organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.organisation.Entities.Organisation;

import java.util.List;
import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation,Long> {
    Organisation findOneByEmail(String email);
    Optional<Organisation> findByNom(String nom);
    Boolean existsByEmail(String email);
    List<Organisation> findByEtat(Boolean etat);

}
