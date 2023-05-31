package com.tunisair.models;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Restauration", uniqueConstraints = {
        @UniqueConstraint(columnNames = "idrestauration"),

})
public class Restauration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestauration;

    private String nom;

    private String email;

    private String telephone;

    private String adresse;

    private String typecuisine;

    // @ManyToMany(mappedBy = "restaurations")
    // @ManyToMany
    // @JoinTable(
    // name = "Menu",
    // joinColumns = @JoinColumn(name = "idRestauration"),
    // inverseJoinColumns = @JoinColumn(name = "numeroVol")
    // )
    // @JsonIgnoreProperties("restaurations")
    // private Set<Vol> vols = new HashSet<>();
    // @ManyToOne
    // @JoinColumn(name = "menu_id_menu")
    // private Menu menu;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "restaurations")
    @JsonIgnore
    private Set<Vol> vols = new HashSet<>();

    public Long getIdRestauration() {
        return this.idRestauration;
    }

    public void setIdRestauration(Long idrestauration) {
        this.idRestauration = idrestauration;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTypecuisine() {
        return this.typecuisine;
    }

    public void setTypecuisine(String typecuisine) {
        this.typecuisine = typecuisine;
    }

    public Set<Vol> getVols() {
        return this.vols;
    }

    public void setVols(Set<Vol> vols) {
        this.vols = vols;
    }
    // public Menu getMenu() {
    // return this.menu;
    // }

    // public void setMenu(Menu menu) {
    // this.menu = menu;
    // }

}