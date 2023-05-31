package com.tunisair.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu implements Serializable {

    @EmbeddedId
    private MenuId id;
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<MenuItem> menuItems;

   
    @MapsId("numeroVol")
    @ManyToOne
    @JoinColumn(name = "numeroVol")
    private Vol vol;

    @MapsId("idRestauration")
    @ManyToOne
    @JoinColumn(name = "idRestauration")
    private Restauration restauration;


    public MenuId getId() {
        return id;
    }

    public void setId(MenuId id) {
        this.id = id;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Restauration getRestauration() {
        return restauration;
    }

    public void setRestauration(Restauration restauration) {
        this.restauration = restauration;
    }
}
