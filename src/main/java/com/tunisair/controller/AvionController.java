package com.tunisair.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tunisair.models.Avion;
import com.tunisair.service.AvionService;

import java.util.List;

@RestController
@RequestMapping("/avions")
public class AvionController {
    private AvionService avionService;

    @Autowired
    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping
    public ResponseEntity<Avion> createAvion(@RequestBody Avion avion) {
        Avion createdAvion = avionService.saveAvion(avion);
        return new ResponseEntity<>(createdAvion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avion> getAvionById(@PathVariable Long id) {
        Avion avion = avionService.getAvionById(id);
        if (avion != null) {
            return new ResponseEntity<>(avion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Avion>> getAllAvions() {
        List<Avion> avions = avionService.getAllAvions();
        return new ResponseEntity<>(avions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvionById(@PathVariable Long id) {
        avionService.deleteAvionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

