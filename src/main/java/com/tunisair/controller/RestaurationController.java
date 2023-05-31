package com.tunisair.controller;

import com.tunisair.models.Restauration;
import com.tunisair.service.RestaurationService;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurations")
public class RestaurationController {

    private final RestaurationService restaurationService;

    public RestaurationController(RestaurationService restaurationService) {
        this.restaurationService = restaurationService;
    }
    @GetMapping
    public ResponseEntity<List<Restauration>> getAllRestaurations() {
        List<Restauration> restaurations = restaurationService.getAllRestaurations();
        return ResponseEntity.ok(restaurations);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restauration> getRestauration(@PathVariable("id") Long id) throws NotFoundException {
        Restauration restauration = restaurationService.getRestauration(id);
        return ResponseEntity.ok(restauration);
    }

    @PostMapping
    public ResponseEntity<Restauration> createRestauration(@RequestBody Restauration restauration) {
        Restauration createdRestauration = restaurationService.createRestauration(restauration);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestauration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restauration> updateRestauration(@PathVariable("id") Long id,
                                                           @RequestBody Restauration restauration) throws NotFoundException {
        Restauration updatedRestauration = restaurationService.updateRestauration(id, restauration);
        return ResponseEntity.ok(updatedRestauration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestauration(@PathVariable("id") Long id) throws NotFoundException {
        restaurationService.deleteRestauration(id);
        return ResponseEntity.noContent().build();
    }
}
