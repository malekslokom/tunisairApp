package com.tunisair.models;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "equipage", uniqueConstraints = { 
    @UniqueConstraint(columnNames = "idEquipage")
   
})

public class Equipage implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipage;
    
    @OneToOne
    @JoinColumn(name = "pilote_id")
    private Pilote pilote;

    @OneToOne
    @JoinColumn(name = "copilote_id")
    private CoPilote coPilote;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "equipage")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    private List<Staff> staffs;
    
    @OneToMany(mappedBy = "equipage")
    @JsonIgnore
    private List<Vol> vols;
    

    public Long getIdEquipage() {
        return this.idEquipage;
    }

    public void setIdEquipage(Long idEquipage) {
        this.idEquipage = idEquipage;
    }

    public Pilote getPilote() {
        return this.pilote;
    }

    public void setPilote(Pilote pilote) {
        this.pilote = pilote;
    }

    public CoPilote getCoPilote() {
        return this.coPilote;
    }

    public void setCoPilote(CoPilote coPilote) {
        this.coPilote = coPilote;
    }

    public List<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
     
    }

    public List<Vol> getVols() {
        return this.vols;
    }

    public void setVols(List<Vol> vols) {
        this.vols = vols;
    }
    public Equipage() {
        this.staffs = new ArrayList<>();
    }
    
}