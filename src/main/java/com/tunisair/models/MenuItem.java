package com.tunisair.models;

import javax.persistence.*;


import java.io.Serializable;

@Entity
@Table(name = "menu_item")
public class MenuItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "menu_numero_vol", referencedColumnName = "numeroVol"),
        @JoinColumn(name = "menu_id_restauration", referencedColumnName = "idRestauration")
})
    private Menu menu;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}