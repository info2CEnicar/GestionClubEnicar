package tn.enicarthage.gestionclub.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Evenement {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	String description;
	Date dateEvenement;
	boolean accepted=false;
	boolean consulte = false;
	@ManyToOne
	Club club;
	@OneToMany(mappedBy = "evenement")
	List<Materiel> materiels;
	@OneToMany(mappedBy = "evenement")
	List<Salle> salles;
}