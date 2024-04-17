package tn.enicarthage.gestionclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.enicarthage.gestionclub.entities.Salle;

@RepositoryRestResource
@CrossOrigin("*")
public interface SalleRepository extends JpaRepository<Salle, Long>{

}
