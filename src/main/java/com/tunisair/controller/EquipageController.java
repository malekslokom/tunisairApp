package com.tunisair.controller;

import com.tunisair.models.Equipage;
import com.tunisair.service.EquipageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipage")
public class EquipageController {
    private final EquipageService equipageService;

    @Autowired
    public EquipageController(EquipageService equipageService) {
        this.equipageService = equipageService;
    }

    @GetMapping
    public List<Equipage> getAllEquipages() {
        return equipageService.getAllEquipages();
    }

    @GetMapping("/{id}")
    public Equipage getEquipageById(@PathVariable("id") Long id) {
        return equipageService.getEquipageById(id);
    }

    @PostMapping
    public Equipage saveEquipage(@RequestBody Equipage equipage) {
        return equipageService.saveEquipage(equipage);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipageById(@PathVariable("id") Long id) {
        equipageService.deleteEquipageById(id);
    }
}
