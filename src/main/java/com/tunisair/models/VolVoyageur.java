package com.tunisair.models;
import javax.persistence.Entity;

@Entity
public class VolVoyageur extends Vol {
    private int nbPassagers;
    private String type;

    public VolVoyageur() {
    }

    public int getNbPassagers() {
        return this.nbPassagers;
    }

    public void setNbPassagers(int nbPassagers) {
        this.nbPassagers = nbPassagers;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
