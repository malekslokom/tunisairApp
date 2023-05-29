package com.tunisair.controller;

import com.tunisair.models.Escale;
import com.tunisair.service.EscaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escale")
public class EscaleController {
    private final EscaleService escaleService;

    @Autowired
    public EscaleController(EscaleService escaleService) {
        this.escaleService = escaleService;
    }

    @GetMapping
    public List<Escale> getAllEscales() {
        return escaleService.getAllEscales();
    }

    @GetMapping("/{id}")
    public Escale getEscaleById(@PathVariable("id") Long id) {
        return escaleService.getEscaleById(id);
    }

    @PostMapping
    public Escale saveEscale(@RequestBody Escale escale) {
        return escaleService.saveEscale(escale);
    }

    @DeleteMapping("/{id}")
    public void deleteEscaleById(@PathVariable("id") Long id) {
        escaleService.deleteEscaleById(id);
    }
}
