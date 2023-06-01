package com.tunisair.models;
import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Staff")
public class Staff extends Employe implements Serializable{


    private String role;
    
    private int experience;
    
    @ManyToOne(fetch = FetchType.LAZY)   
     @JsonIgnore
    @JoinColumn(name = "equipage_Id")
    private Equipage equipage;

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Equipage getEquipage() {
        return this.equipage;
    }

    public void setEquipage(Equipage equipage) {
        this.equipage = equipage;
    }
    

}
