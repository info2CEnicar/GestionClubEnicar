package tn.enicarthage.gestionclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.enicarthage.gestionclub.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
}