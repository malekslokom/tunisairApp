package com.tunisair.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tunisair.models.*;
import com.tunisair.service.AeroportService;

import javassist.NotFoundException;


@RestController
@RequestMapping("/api/aeroports")
public class AeroportController {

    private final AeroportService aeroportService;

    public AeroportController(AeroportService aeroportService) {
        this.aeroportService = aeroportService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeroport> getAeroportById(@PathVariable("id") Long id) throws NotFoundException {
        Aeroport aeroport = aeroportService.getAeroportById(id);
        return ResponseEntity.ok(aeroport);
    }

    @PostMapping
    public ResponseEntity<Aeroport> createAeroport(@RequestBody Aeroport aeroport) {
        Aeroport createdAeroport = aeroportService.createAeroport(aeroport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAeroport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeroport> updateAeroport(@PathVariable("id") Long id, @RequestBody Aeroport aeroport) throws NotFoundException {
        Aeroport updatedAeroport = aeroportService.updateAeroport(id, aeroport);
        return ResponseEntity.ok(updatedAeroport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroport(@PathVariable("id") Long id) throws NotFoundException {
        aeroportService.deleteAeroport(id);
        return ResponseEntity.noContent().build();
    }
}