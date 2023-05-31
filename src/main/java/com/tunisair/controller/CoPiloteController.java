package com.tunisair.controller;

import com.tunisair.models.CoPilote;
import com.tunisair.models.CoPilote;
import com.tunisair.service.CoPiloteService;
import com.tunisair.service.CoPiloteService;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/copilotes")
public class CoPiloteController {

    private final CoPiloteService coPiloteService;

    public CoPiloteController(CoPiloteService coPiloteService) {
        this.coPiloteService = coPiloteService;
    }
    @GetMapping
    public ResponseEntity<List<CoPilote>> getAllCoPilotes() {
        List<CoPilote> coPilotes = coPiloteService.getAllCoPilotes();
        return ResponseEntity.ok(coPilotes);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CoPilote> getCoPilote(@PathVariable("id") Long id) throws NotFoundException {
        CoPilote coPilote = coPiloteService.getCoPilote(id);
        return ResponseEntity.ok(coPilote);
    }

    @PostMapping
    public ResponseEntity<CoPilote> createCoPilote(@RequestBody CoPilote coPilote) {
        CoPilote createdCoPilote = coPiloteService.createCoPilote(coPilote);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoPilote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoPilote> updateCoPilote(@PathVariable("id") Long id,
                                               @RequestBody CoPilote coPilote) throws NotFoundException {
        CoPilote updatedCoPilote = coPiloteService.updateCoPilote(id, coPilote);
        return ResponseEntity.ok(updatedCoPilote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoPilote(@PathVariable("id") Long id) throws NotFoundException {
        coPiloteService.deleteCoPilote(id);
        return ResponseEntity.noContent().build();
    }
}
