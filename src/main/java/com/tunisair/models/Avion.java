package com.tunisair.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "avion", uniqueConstraints = { 
    @UniqueConstraint(columnNames = "idAvion")
   
})
public class Avion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvion;
    private String nomAvion;
    private String modele;
    private String type;
    private String capacité;
    private String etat;
    
    @OneToMany(mappedBy = "avion")
    @JsonIgnore
    private List<Vol> vols;
    
    public Long getIdAvion() {
        return idAvion;
    }
    
    public void setIdAvion(Long idAvion) {
        this.idAvion = idAvion;
    }
    
    public String getNomAvion() {
        return nomAvion;
    }
    
    public void setNomAvion(String nomAvion) {
        this.nomAvion = nomAvion;
    }
    
    public String getModele() {
        return modele;
    }
    
    public void setModele(String modele) {
        this.modele = modele;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getCapacité() {
        return capacité;
    }
    
    public void setCapacité(String capacité) {
        this.capacité = capacité;
    }
    
    public String getEtat() {
        return etat;
    }
    
    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    public List<Vol> getVols() {
        return vols;
    }
    
    public void setVols(List<Vol> vols) {
        this.vols = vols;
    }
}
