package com.tunisair.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tunisair.repositories.*;
import javassist.NotFoundException;
import com.tunisair.models.Avion;

@Service
public class AvionService {

    private final AvionRepository avionRepository;

    public AvionService(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }
    public List<Avion> getAllAvions() {
        return avionRepository.findAll();
    }
    public Avion getAvionById(Long id) throws NotFoundException {
        return avionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Avion not found with id: " + id));
    }

    public Avion createAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    public Avion updateAvion(Long id, Avion avion) throws NotFoundException {
        Avion existingAvion = avionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Avion not found with id: " + id));

        // Update attributes of existingAvion with the new values from avion
        existingAvion.setNomAvion(avion.getNomAvion());
        existingAvion.setModele(avion.getModele());
        existingAvion.setType(avion.getType());
        existingAvion.setCapacité(avion.getCapacité());
        existingAvion.setEtat(avion.getEtat());

        return avionRepository.save(existingAvion);
    }

    public void deleteAvion(Long id) throws NotFoundException {
        if (!avionRepository.existsById(id)) {
            throw new NotFoundException("Avion not found with id: " + id);
        }
        avionRepository.deleteById(id);
    }
}

