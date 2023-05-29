package com.tunisair.models;

import javax.persistence.Entity;

@Entity
public class VolMarchandise extends Vol {
    private double poids;
    private String typeMarchandise;

    public VolMarchandise() {
    }

    public double getPoids() {
        return this.poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getTypeMarchandise() {
        return this.typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }
}
