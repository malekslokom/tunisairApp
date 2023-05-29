package com.tunisair.controller;

import com.tunisair.models.Pilote;
import com.tunisair.service.PiloteService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pilotes")
public class PiloteController {

    private final PiloteService piloteService;

    public PiloteController(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pilote> getPilote(@PathVariable("id") Long id) throws NotFoundException {
        Pilote pilote = piloteService.getPilote(id);
        return ResponseEntity.ok(pilote);
    }

    @PostMapping
    public ResponseEntity<Pilote> createPilote(@RequestBody Pilote pilote) {
        Pilote createdPilote = piloteService.createPilote(pilote);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPilote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pilote> updatePilote(@PathVariable("id") Long id,
                                               @RequestBody Pilote pilote) throws NotFoundException {
        Pilote updatedPilote = piloteService.updatePilote(id, pilote);
        return ResponseEntity.ok(updatedPilote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePilote(@PathVariable("id") Long id) throws NotFoundException {
        piloteService.deletePilote(id);
        return ResponseEntity.noContent().build();
    }
}
