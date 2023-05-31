package com.tunisair.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vol", uniqueConstraints = { @UniqueConstraint(columnNames = "numeroVol") })
@Inheritance(strategy = InheritanceType.JOINED)
public class Vol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroVol;

    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private Integer retard;
    private String etat;

    @ManyToOne
   // @JsonIgnore
    @JoinColumn(name = "aeroport_depart_id_aeroport")
    private Aeroport aeroportDepart;

    @ManyToOne
   // @JsonIgnore
    @JoinColumn(name = "aeroport_destination_id_aeroport")
    private Aeroport aeroportDestination;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "avion_id_avion")
    private Avion avion;

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "equipage_id_equipage")
    private Equipage equipage;


    @ManyToMany(fetch = FetchType.LAZY,
      cascade = {
          CascadeType.PERSIST,
          CascadeType.MERGE
      })
    @JoinTable(
        name = "Menu",
        joinColumns = @JoinColumn(name = "numeroVol"),
        inverseJoinColumns = @JoinColumn(name = "idRestauration")
    )
   //@JsonIgnoreProperties("vols")
    private Set<Restauration> restaurations = new HashSet<>();


    public Long getNumeroVol() {
        return this.numeroVol;
    }

    public void setNumeroVol(Long numeroVol) {
        this.numeroVol = numeroVol;
    }

    public LocalDateTime getDateDepart() {
        return this.dateDepart;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDateTime getDateArrivee() {
        return this.dateArrivee;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Integer getRetard() {
        return this.retard;
    }

    public void setRetard(Integer retard) {
        this.retard = retard;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Aeroport getAeroportDepart() {
        return this.aeroportDepart;
    }

    public void setAeroportDepart(Aeroport aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public Aeroport getAeroportDestination() {
        return this.aeroportDestination;
    }

    public void setAeroportDestination(Aeroport aeroportDestination) {
        this.aeroportDestination = aeroportDestination;
    }

    public Avion getAvion() {
        return this.avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Equipage getEquipage() {
        return this.equipage;
    }

    public void setEquipage(Equipage equipage) {
        this.equipage = equipage;
    }

    // public Set<Aeroport> getAeroports() {
    //     return this.aeroports;
    // }

    // public void setAeroports(Set<Aeroport> aeroports) {
    //     this.aeroports = aeroports;
    // }

    public Set<Restauration> getRestaurations() {
        return this.restaurations;
    }

    public void setRestaurations(Set<Restauration> restaurations) {
        this.restaurations = restaurations;
    }

   
    
}
