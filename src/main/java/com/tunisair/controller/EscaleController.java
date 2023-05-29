package com.tunisair.controller;

import com.tunisair.models.Escale;
import com.tunisair.service.EscaleService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escales")
public class EscaleController {

    private final EscaleService escaleService;

    public EscaleController(EscaleService escaleService) {
        this.escaleService = escaleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escale> getEscaleById(@PathVariable("id") Long id) throws NotFoundException {
        Escale escale = escaleService.getEscaleById(id);
        return ResponseEntity.ok(escale);
    }

    @PostMapping
    public ResponseEntity<Escale> createEscale(@RequestBody Escale escale) {
        Escale createdEscale = escaleService.createEscale(escale);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEscale);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escale> updateEscale(@PathVariable("id") Long id, @RequestBody Escale escale) throws NotFoundException {
        Escale updatedEscale = escaleService.updateEscale(id, escale);
        return ResponseEntity.ok(updatedEscale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEscale(@PathVariable("id") Long id) throws NotFoundException {
        escaleService.deleteEscale(id);
        return ResponseEntity.noContent().build();
    }
}
