package com.tunisair.controller;

import com.tunisair.models.Equipage;
import com.tunisair.service.EquipageService;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipages")
public class EquipageController {

    private final EquipageService equipageService;

    public EquipageController(EquipageService equipageService) {
        this.equipageService = equipageService;
    }
    @GetMapping
    public ResponseEntity<List<Equipage>> getAllEquipages() {
        List<Equipage> equipages = equipageService.getAllEquipages();
        return ResponseEntity.ok(equipages);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Equipage> getEquipageById(@PathVariable("id") Long id) throws NotFoundException {
        Equipage equipage = equipageService.getEquipageById(id);
        return ResponseEntity.ok(equipage);
    }

    @PostMapping
    public ResponseEntity<Equipage> createEquipage(@RequestBody Equipage equipage) {
        Equipage createdEquipage = equipageService.createEquipage(equipage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipage> updateEquipage(@PathVariable("id") Long id, @RequestBody Equipage equipage) throws NotFoundException {
        Equipage updatedEquipage = equipageService.updateEquipage(id, equipage);
        return ResponseEntity.ok(updatedEquipage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipage(@PathVariable("id") Long id) throws NotFoundException {
        equipageService.deleteEquipage(id);
        return ResponseEntity.noContent().build();
    }
}
