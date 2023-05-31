package com.tunisair.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tunisair.models.*;
import com.tunisair.repositories.*;

import javassist.NotFoundException;
@Service
public class AeroportService {

    private final AeroportRepository aeroportRepository;

    public AeroportService(AeroportRepository aeroportRepository) {
        this.aeroportRepository = aeroportRepository;
    }
    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }
    public Aeroport getAeroportById(Long id) throws NotFoundException {
        return aeroportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aeroport not found with id: " + id));
    }

    public Aeroport createAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    public Aeroport updateAeroport(Long id, Aeroport aeroport) throws NotFoundException {
        Aeroport existingAeroport = aeroportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aeroport not found with id: " + id));

        existingAeroport.setNom(aeroport.getNom());
        existingAeroport.setVille(aeroport.getVille());

        return aeroportRepository.save(existingAeroport);
    }

    public void deleteAeroport(Long id) throws NotFoundException {
        if (!aeroportRepository.existsById(id)) {
            throw new NotFoundException("Aeroport not found with id: " + id);
        }
        aeroportRepository.deleteById(id);
    }
}
