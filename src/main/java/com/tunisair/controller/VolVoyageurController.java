package com.tunisair.controller;

import com.tunisair.models.VolVoyageur;
import com.tunisair.service.VolVoyageurService;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volvoyageurs")
public class VolVoyageurController {

    private final VolVoyageurService volVoyageurService;

    @Autowired
    public VolVoyageurController(VolVoyageurService volVoyageurService) {
        this.volVoyageurService = volVoyageurService;
    }

    @GetMapping
    public ResponseEntity<List<VolVoyageur>> getAllVolVoyageurs() {
        List<VolVoyageur> volVoyageurs = volVoyageurService.getAllVolVoyageurs();
        return new ResponseEntity<>(volVoyageurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolVoyageur> getVolVoyageurById(@PathVariable Long id) {
        VolVoyageur volVoyageur = volVoyageurService.getVolVoyageurById(id);
        if (volVoyageur != null) {
            return new ResponseEntity<>(volVoyageur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<VolVoyageur> createVolVoyageur(@RequestBody VolVoyageur volVoyageur) {
        VolVoyageur createdVolVoyageur = volVoyageurService.createVolVoyageur(volVoyageur);
        return new ResponseEntity<>(createdVolVoyageur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VolVoyageur> updateVolVoyageur(@PathVariable Long id, @RequestBody VolVoyageur volVoyageur) {
        VolVoyageur updatedVolVoyageur = volVoyageurService.updateVolVoyageur(id, volVoyageur);
        if (updatedVolVoyageur != null) {
            return new ResponseEntity<>(updatedVolVoyageur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVolVoyageur(@PathVariable Long id) throws NotFoundException {
        boolean deleted = volVoyageurService.deleteVolVoyageur(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
