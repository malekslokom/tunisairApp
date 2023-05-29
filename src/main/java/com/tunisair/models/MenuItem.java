package com.tunisair.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu_item")
public class MenuItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToMany(mappedBy = "menuItems")
    private List<Menu> menus;



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

    public List<Menu> getMenus() {
        return this.menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

}