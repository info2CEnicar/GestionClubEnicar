package tn.enicarthage.gestionclub.entities;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("RESPONSABLE_CLUB")
public class ResponsableClub extends Utilisateur{
	@OneToMany(mappedBy = "responsableClub")
	List<Club> clubs;
}
