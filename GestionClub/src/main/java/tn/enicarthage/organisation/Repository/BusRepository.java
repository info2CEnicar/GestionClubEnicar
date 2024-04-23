package tn.enicarthage.organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.organisation.Entities.Bus;
import tn.enicarthage.organisation.Entities.Organisation;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {
    List<Bus> findByAcceptee(Boolean acceptee);
    List<Bus> findByNomOrganisation(String nomOrganisation);
}
