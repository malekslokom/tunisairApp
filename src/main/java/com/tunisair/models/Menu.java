package com.tunisair.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
// @Entity
// @Table(name = "menu")
// public class Menu implements Serializable {

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//     @EmbeddedId
//     private MenuId id;

//     @ManyToMany(cascade = CascadeType.ALL)
//     @JoinTable(
//         name = "menu_menu_item",
//         joinColumns = {
//             @JoinColumn(name = "menu_numero_vol", referencedColumnName = "numeroVol"),
//             @JoinColumn(name = "menu_id_restauration", referencedColumnName = "idRestauration")
//         },
//         inverseJoinColumns = @JoinColumn(name = "menu_item_id")
//     )
//     private List<MenuItem> menuItems;
//     @ManyToOne
//     @MapsId("volId")
//     private Vol vol;

//     @ManyToOne
//     @MapsId("restaurationId")
//     private Restauration restauration;
    

//     // Constructors, getters, and setters

//     public MenuId getId() {
//         return id;
//     }

//     public void setId(MenuId id) {
//         this.id = id;
//     }

//     public List<MenuItem> getMenuItems() {
//         return menuItems;
//     }

//     public void setMenuItems(List<MenuItem> menuItems) {
//         this.menuItems = menuItems;
//     }

// }

@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu implements Serializable {

    @EmbeddedId
    private MenuId id;

    // @ManyToMany(cascade = CascadeType.ALL)
    // @JoinTable(
    //     name = "menu_menu_item",
    //     joinColumns = {
    //         @JoinColumn(name = "menu_numero_vol", referencedColumnName = "numeroVol"),
    //         @JoinColumn(name = "menu_id_restauration", referencedColumnName = "idrestauration")
    //     },
    //     inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    // )
    // private List<MenuItem> menuItems;
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

    // Constructors, getters, and setters

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
