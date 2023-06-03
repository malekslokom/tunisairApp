package com.tunisair.controller;

import com.tunisair.models.Employe;
import com.tunisair.service.EmployeService;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/employes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }
    @GetMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<Employe>> getAllEmployes() {
        List<Employe> employes = employeService.getAllEmployes();
        return ResponseEntity.ok(employes);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("id") Long id) throws NotFoundException {
        Employe employe = employeService.getEmployeById(id);
        return ResponseEntity.ok(employe);
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmploye);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id") Long id, @RequestBody Employe employe) throws NotFoundException {
        Employe updatedEmploye = employeService.updateEmploye(id, employe);
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEmploye(@PathVariable("id") Long id) throws NotFoundException {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
