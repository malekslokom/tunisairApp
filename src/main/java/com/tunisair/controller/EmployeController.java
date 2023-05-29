package com.tunisair.controller;

import com.tunisair.models.Employe;
import com.tunisair.service.EmployeService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getEmployeById(@PathVariable("id") Long id) throws NotFoundException {
        Employe employe = employeService.getEmployeById(id);
        return ResponseEntity.ok(employe);
    }

    @PostMapping
    public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
        Employe createdEmploye = employeService.createEmploye(employe);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmploye);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> updateEmploye(@PathVariable("id") Long id, @RequestBody Employe employe) throws NotFoundException {
        Employe updatedEmploye = employeService.updateEmploye(id, employe);
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable("id") Long id) throws NotFoundException {
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
