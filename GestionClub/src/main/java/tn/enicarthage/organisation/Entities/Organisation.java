package tn.enicarthage.organisation.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "organisations")
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String type; 
    @Lob
    private String logo;
    private String description;
    private Long tel;
    private String email;
    private String mdp;
    private String nomResp; 
    private String prenomResp; 
    private Boolean etat=false;
    @OneToMany
    private List<Bus> demandesBus;
    @OneToMany
    private List<Materiel> demandesMateriel;
    @OneToMany
    private List<Salle> demandesSalle;
}
