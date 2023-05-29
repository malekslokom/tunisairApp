package com.tunisair.controller;

import com.tunisair.models.Pilote;
import com.tunisair.service.PiloteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotes")
public class PiloteController {
    private final PiloteService piloteService;

    @Autowired
    public PiloteController(PiloteService piloteService) {
        this.piloteService = piloteService;
    }

    @GetMapping
    public List<Pilote> getAllPilotes() {
        return piloteService.getAllPilotes();
    }

    @GetMapping("/{id}")
    public Pilote getPiloteById(@PathVariable("id") Long id) {
        return piloteService.getPiloteById(id);
    }

    @PostMapping
    public Pilote savePilote(@RequestBody Pilote pilote) {
        return piloteService.savePilote(pilote);
    }

    @DeleteMapping("/{id}")
    public void deletePiloteById(@PathVariable("id") Long id) {
        piloteService.deletePiloteById(id);
    }
}
