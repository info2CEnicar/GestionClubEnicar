package tn.enicarthage.organisation.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numSalle;
    private String batiment; 
    @Temporal(TemporalType.DATE)
    private Date date;
    private LocalTime temps;
    private int duree;
    private String raison;
    private Boolean etat=null;
    private String nomOrganisation;
}
