package com.tunisair.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.tunisair.models.Avion;
import com.tunisair.service.AvionService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/avions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<Avion>> getAllAvions() {
        List<Avion> avions = avionService.getAllAvions();
        return ResponseEntity.ok(avions);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Avion> getAvionById(@PathVariable("id") Long id) throws NotFoundException {
        Avion avion = avionService.getAvionById(id);
        return ResponseEntity.ok(avion);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Avion> createAvion(@RequestBody Avion avion) {
        Avion createdAvion = avionService.createAvion(avion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAvion);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Avion> updateAvion(@PathVariable("id") Long id, @RequestBody Avion avion) throws NotFoundException {
        Avion updatedAvion = avionService.updateAvion(id, avion);
        return ResponseEntity.ok(updatedAvion);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAvion(@PathVariable("id") Long id) throws NotFoundException {
        avionService.deleteAvion(id);
        return ResponseEntity.noContent().build();
    }
}
