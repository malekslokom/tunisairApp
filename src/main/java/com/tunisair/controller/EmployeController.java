package com.tunisair.controller;

import com.tunisair.models.Employe;
import com.tunisair.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable("id") Long id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping
    public Employe saveEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeById(@PathVariable("id") Long id) {
        employeService.deleteEmployeById(id);
    }
}
