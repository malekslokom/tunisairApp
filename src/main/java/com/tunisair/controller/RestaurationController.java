package com.tunisair.controller;

import com.tunisair.models.Restauration;
import com.tunisair.service.RestaurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurations")
public class RestaurationController {
    private final RestaurationService restaurationService;

    @Autowired
    public RestaurationController(RestaurationService restaurationService) {
        this.restaurationService = restaurationService;
    }

    @GetMapping
    public List<Restauration> getAllRestaurations() {
        return restaurationService.getAllRestaurations();
    }

    @GetMapping("/{id}")
    public Restauration getRestaurationById(@PathVariable("id") Long id) {
        return restaurationService.getRestaurationById(id);
    }

    @PostMapping
    public Restauration createRestauration(@RequestBody Restauration restauration) {
        return restaurationService.saveRestauration(restauration);
    }

    @PutMapping("/{id}")
    public Restauration updateRestauration(@PathVariable("id") Long id, @RequestBody Restauration restauration) {
        return restaurationService.updateRestauration(id, restauration);
    }

    @DeleteMapping("/{id}")
    public void deleteRestauration(@PathVariable("id") Long id) {
        restaurationService.deleteRestaurationById(id);
    }
}
