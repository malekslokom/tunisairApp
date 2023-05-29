package com.tunisair.models;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "equipage", uniqueConstraints = { 
    @UniqueConstraint(columnNames = "idEquipage")
   
})
public class Equipage{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipage;
    
    @OneToMany(mappedBy = "equipage")
    private List<Pilote> pilotes;
    
    @OneToMany(mappedBy = "equipage")
    private List<Staff> staffs;
    
    @OneToMany(mappedBy = "equipage")
    private List<Vol> vols;
    

    public Long getIdEquipage() {
        return this.idEquipage;
    }

    public void setIdEquipage(Long idEquipage) {
        this.idEquipage = idEquipage;
    }

    public List<Pilote> getPilotes() {
        return this.pilotes;
    }

    public void setPilotes(List<Pilote> pilotes) {
        this.pilotes = pilotes;
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

}