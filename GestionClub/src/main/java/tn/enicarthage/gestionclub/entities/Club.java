package tn.enicarthage.gestionclub.entities;

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
public class Club {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	String description;
	String type;
	String image;
	@OneToMany(mappedBy = "club")
	List<Evenement> evenements;
	@OneToOne
	User user;
}
