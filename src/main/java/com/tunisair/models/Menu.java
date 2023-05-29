package com.tunisair.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name = "menu")
public class Menu implements Serializable{ 

    @Id
    @Column(name = "numeroVol")
    private Long numeroVol;

    @Id
    @Column(name = "idRestauration")
    private Long idRestauration;

    // Other attributes and relationships

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "menu_menu_item",
            joinColumns = {
                @JoinColumn(name = "menu_numero_vol", referencedColumnName = "numeroVol"),
                @JoinColumn(name = "menu_id_restauration", referencedColumnName = "idRestauration")
            },
            inverseJoinColumns = @JoinColumn(name = "menu_item_id"))
    private List<MenuItem> menuItems;

    // Constructors, getters, and setters

    public Long getNumeroVol() {
        return this.numeroVol;
    }

    public void setNumeroVol(Long numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Long getIdRestauration() {
        return this.idRestauration;
    }

    public void setIdRestauration(Long idRestauration) {
        this.idRestauration = idRestauration;
    }

    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


}


