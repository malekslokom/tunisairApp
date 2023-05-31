package com.tunisair.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pilote extends Employe {

    private int nbHeuresVol;
    
    private String numeroLicence;
    
    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "equipage_Id")
    private Equipage equipage;

    public int getNbHeuresVol() {
        return this.nbHeuresVol;
    }

    public void setNbHeuresVol(int nbHeuresVol) {
        this.nbHeuresVol = nbHeuresVol;
    }

    public String getNumeroLicence() {
        return this.numeroLicence;
    }

    public void setNumeroLicence(String numeroLicence) {
        this.numeroLicence = numeroLicence;
    }

    public Equipage getEquipage() {
        return this.equipage;
    }

    public void setEquipage(Equipage equipage) {
        this.equipage = equipage;
    }
}
