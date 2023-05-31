package com.tunisair.models;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "aeroport", uniqueConstraints = { 
    @UniqueConstraint(columnNames = "idAeroport")
   
})
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAeroport;

    private String nom;
    private String ville;

    @OneToMany(mappedBy = "aeroportDepart")
    private List<Vol> volsDepart;

    @OneToMany(mappedBy = "aeroportDestination")
    private List<Vol> volsDestination;


    public Long getIdAeroport() {
        return this.idAeroport;
    }

    public void setIdAeroport(Long idAeroport) {
        this.idAeroport = idAeroport;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}