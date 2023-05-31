package com.tunisair.models;
import javax.persistence.*;

@Entity
@Table(name = "Staff")
public class Staff extends Employe {


    private String role;
    
    private int experience;
    
    @ManyToOne
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
