package tn.enicarthage.gestionclub.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.enicarthage.gestionclub.entities.Evenement;

@RepositoryRestResource
@CrossOrigin("*")
public interface EvenementRepository extends JpaRepository<Evenement, Long>{
	
	List<Evenement> findByDateEvenement(Date date);
}
