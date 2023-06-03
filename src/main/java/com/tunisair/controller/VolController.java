package com.tunisair.controller;

import com.tunisair.models.Vol;
import com.tunisair.service.VolService;

import javassist.NotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/vols")
public class VolController {

    private final VolService volService;

    public VolController(VolService volService) {
        this.volService = volService;
    }
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<Vol>> getAllVols() {
        List<Vol> vols = volService.getAllVols();
        return ResponseEntity.ok(vols);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Vol> getVolById(@PathVariable("id") Long id) throws NotFoundException {
        Vol vol = volService.getVolById(id);
        return ResponseEntity.ok(vol);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Vol> createVol(@RequestBody Vol vol) {
        
        Vol createdVol = volService.createVol(vol);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVol);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Vol> updateVol(@PathVariable("id") Long id, @RequestBody Vol vol) throws NotFoundException {
        Vol updatedVol = volService.updateVol(id, vol);
        return ResponseEntity.ok(updatedVol);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteVol(@PathVariable("id") Long id) throws NotFoundException {
        volService.deleteVol(id);
        return ResponseEntity.noContent().build();
    }
}