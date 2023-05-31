package com.tunisair.service;

import com.tunisair.models.Pilote;
import com.tunisair.repositories.PiloteRepository;
import javassist.NotFoundException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PiloteService {

    private final PiloteRepository piloteRepository;

    public PiloteService(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }
    public List<Pilote> getAllPilotes() {
        return piloteRepository.findAll();
    }
    public Pilote getPilote(Long id) throws NotFoundException {
        return piloteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pilote not found with id: " + id));
    }

    public Pilote createPilote(Pilote pilote) {
        return piloteRepository.save(pilote);
    }

    public Pilote updatePilote(Long id, Pilote pilote) throws NotFoundException {
        Pilote existingPilote = getPilote(id);

        // Update attributes of existingPilote with the new values from pilote
        existingPilote.setNbHeuresVol(pilote.getNbHeuresVol());
        existingPilote.setNumeroLicence(pilote.getNumeroLicence());
        existingPilote.setEquipage(pilote.getEquipage());

        return piloteRepository.save(existingPilote);
    }

    public void deletePilote(Long id) throws NotFoundException {
        Pilote existingPilote = getPilote(id);
        piloteRepository.delete(existingPilote);
    }
}
