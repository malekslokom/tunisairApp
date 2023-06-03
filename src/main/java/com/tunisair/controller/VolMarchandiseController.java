package com.tunisair.controller;

import com.tunisair.models.VolMarchandise;
import com.tunisair.service.VolMarchandiseService;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/volMarchandises")
public class VolMarchandiseController {

    private final VolMarchandiseService volMarchandiseService;

    @Autowired
    public VolMarchandiseController(VolMarchandiseService volMarchandiseService) {
        this.volMarchandiseService = volMarchandiseService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolMarchandise> getVolMarchandiseById(@PathVariable Long id) throws NotFoundException {
        VolMarchandise volMarchandise = volMarchandiseService.getVolMarchandiseById(id);
        return ResponseEntity.ok(volMarchandise);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<VolMarchandise>> getAllVolMarchandises() {
        List<VolMarchandise> volMarchandises = volMarchandiseService.getAllVolMarchandises();
        return ResponseEntity.ok(volMarchandises);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolMarchandise> createVolMarchandise(@RequestBody VolMarchandise volMarchandise) {
        VolMarchandise createdVolMarchandise = volMarchandiseService.createVolMarchandise(volMarchandise);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVolMarchandise);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<VolMarchandise> updateVolMarchandise(
            @PathVariable Long id,
            @RequestBody VolMarchandise volMarchandise
    ) throws NotFoundException {
        VolMarchandise updatedVolMarchandise = volMarchandiseService.updateVolMarchandise(id, volMarchandise);
        return ResponseEntity.ok(updatedVolMarchandise);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteVolMarchandise(@PathVariable Long id) throws NotFoundException {
        volMarchandiseService.deleteVolMarchandise(id);
        return ResponseEntity.noContent().build();
    }
}
