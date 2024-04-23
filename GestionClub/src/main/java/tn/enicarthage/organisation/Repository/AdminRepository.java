package tn.enicarthage.organisation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enicarthage.organisation.Entities.Admin;
import tn.enicarthage.organisation.Entities.Organisation;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
    Boolean existsByEmail(String email);
}
