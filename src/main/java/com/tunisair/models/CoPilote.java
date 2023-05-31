package com.tunisair.models;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class CoPilote extends Employe implements Serializable {

    private int nbHeuresVol;
    
    private String numeroLicence;
    
    @OneToOne
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
