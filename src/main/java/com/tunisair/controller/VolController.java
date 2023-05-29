package com.tunisair.controller;

import com.tunisair.models.Vol;
import com.tunisair.service.VolService;

import javassist.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vols")
public class VolController {

    private final VolService volService;

    public VolController(VolService volService) {
        this.volService = volService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vol> getVolById(@PathVariable("id") Long id) throws NotFoundException {
        Vol vol = volService.getVolById(id);
        return ResponseEntity.ok(vol);
    }

    @PostMapping
    public ResponseEntity<Vol> createVol(@RequestBody Vol vol) {
        Vol createdVol = volService.createVol(vol);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vol> updateVol(@PathVariable("id") Long id, @RequestBody Vol vol) throws NotFoundException {
        Vol updatedVol = volService.updateVol(id, vol);
        return ResponseEntity.ok(updatedVol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVol(@PathVariable("id") Long id) throws NotFoundException {
        volService.deleteVol(id);
        return ResponseEntity.noContent().build();
    }
}