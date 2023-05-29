package com.tunisair.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "escale")
public class Escale implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "vol_id")
    private Vol vol;


    @ManyToOne
    @JoinColumn(name = "aeroport_id")
    private Aeroport aeroport;


    // Constructors, getters, and setters


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Vol getVol() {
        return this.vol;
    }


    public void setVol(Vol vol) {
        this.vol = vol;
    }


    public Aeroport getAeroport() {
        return this.aeroport;
    }


    public void setAeroport(Aeroport aeroport) {
        this.aeroport = aeroport;
    }


}













