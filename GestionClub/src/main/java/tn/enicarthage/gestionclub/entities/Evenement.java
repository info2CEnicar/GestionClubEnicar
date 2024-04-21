package tn.enicarthage.gestionclub.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
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
public class Evenement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	String description;
	int nbrParticipant;
	@Temporal(TemporalType.DATE)
	Date dateEvenement;
	boolean accepted=false;
	boolean consulte = false;
	@ManyToOne
	Club club;
	@OneToMany
	List<Materiel> materiels;
	@OneToMany
	List<Salle> salles;
}
