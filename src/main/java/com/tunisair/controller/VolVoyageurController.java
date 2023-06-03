package com.tunisair.controller;

import com.tunisair.models.VolVoyageur;
import com.tunisair.service.VolVoyageurService;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/volvoyageurs")
public class VolVoyageurController {

    private final VolVoyageurService volVoyageurService;

    @Autowired
    public VolVoyageurController(VolVoyageurService volVoyageurService) {
        this.volVoyageurService = volVoyageurService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<VolVoyageur>> getAllVolVoyageurs() {
        List<VolVoyageur> volVoyageurs = volVoyageurService.getAllVolVoyageurs();
        return ResponseEntity.ok(volVoyageurs);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolVoyageur> getVolVoyageurById(@PathVariable Long id) throws NotFoundException {
        VolVoyageur volVoyageur = volVoyageurService.getVolVoyageurById(id);
        return ResponseEntity.ok(volVoyageur);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolVoyageur> createVolVoyageur(@RequestBody VolVoyageur volVoyageur) {
        VolVoyageur createdVolVoyageur = volVoyageurService.createVolVoyageur(volVoyageur);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVolVoyageur);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolVoyageur> updateVolVoyageur(@PathVariable Long id, @RequestBody VolVoyageur volVoyageur) throws NotFoundException {
        VolVoyageur updatedVolVoyageur = volVoyageurService.updateVolVoyageur(id, volVoyageur);
        return ResponseEntity.ok(updatedVolVoyageur);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteVolVoyageur(@PathVariable Long id) throws NotFoundException {
        volVoyageurService.deleteVolVoyageur(id);
        return ResponseEntity.noContent().build();
    }
}
