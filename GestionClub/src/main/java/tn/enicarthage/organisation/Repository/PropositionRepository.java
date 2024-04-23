package tn.enicarthage.organisation.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.enicarthage.organisation.Entities.Proposition;
import tn.enicarthage.organisation.Entities.Reclamation;

public interface PropositionRepository extends CrudRepository<Proposition, Long> {
}
