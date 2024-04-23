package tn.enicarthage.organisation.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String materiel;
    @Temporal(TemporalType.DATE)
    private Date date;
    private LocalTime temps; 
    private int duree;
    private int quantite;
    private String raison;
    private Boolean etat=null;
    private String nomOrganisation;
}
