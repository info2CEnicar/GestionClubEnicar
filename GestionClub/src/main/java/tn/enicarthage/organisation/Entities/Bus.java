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
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    @Temporal(TemporalType.DATE)
    private Date dateDep;
    @Temporal(TemporalType.DATE)
    private Date dateArr; 
    private LocalTime heureDep; 
    private LocalTime heureArr; 
    private String raison;
    private Boolean acceptee=null;
    private String nomOrganisation;
}
