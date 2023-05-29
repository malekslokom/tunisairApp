package com.tunisair.service;

import com.tunisair.models.Pilote;
import com.tunisair.repositories.PiloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiloteService {
    private final PiloteRepository piloteRepository;

    @Autowired
    public PiloteService(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }

    // Implement service methods for Pilote class
    public List<Pilote> getAllPilotes() {
        return piloteRepository.findAll();
    }

    public Pilote getPiloteById(Long id) {
        return piloteRepository.findById(id).orElse(null);
    }

    public Pilote savePilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    public void deletePiloteById(Long id) {
        piloteRepository.deleteById(id);
    }
}
