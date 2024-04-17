package tn.enicarthage.gestionclub.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Materiel {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	int quantiteDemande;
	final int quantiteDisponible;
	@ManyToOne
	Evenement evenement;
}
