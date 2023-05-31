package com.tunisair.service;

import com.tunisair.models.VolMarchandise;
import com.tunisair.repositories.VolMarchandiseRepository;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolMarchandiseService {

    private final VolMarchandiseRepository volMarchandiseRepository;

    @Autowired
    public VolMarchandiseService(VolMarchandiseRepository volMarchandiseRepository) {
        this.volMarchandiseRepository = volMarchandiseRepository;
    }

    public VolMarchandise getVolMarchandiseById(Long id) {
        return volMarchandiseRepository.findById(id).orElse(null);
    }

    public List<VolMarchandise> getAllVolMarchandises() {
        return volMarchandiseRepository.findAll();
    }

    public VolMarchandise createVolMarchandise(VolMarchandise volMarchandise) {
        return volMarchandiseRepository.save(volMarchandise);
    }

    public VolMarchandise updateVolMarchandise(Long id, VolMarchandise volMarchandise) throws NotFoundException {
        VolMarchandise existingVolMarchandise = volMarchandiseRepository.findById(id).orElse(null);
        if (existingVolMarchandise != null) {
            // Update the attributes of the existingVolMarchandise object with the new values
            existingVolMarchandise.setPoids(volMarchandise.getPoids());
            existingVolMarchandise.setTypeMarchandise(volMarchandise.getTypeMarchandise());
    
            // Update attributes inherited from Vol class
            existingVolMarchandise.setDateDepart(volMarchandise.getDateDepart());
            existingVolMarchandise.setDateArrivee(volMarchandise.getDateArrivee());
            existingVolMarchandise.setRetard(volMarchandise.getRetard());
            existingVolMarchandise.setEtat(volMarchandise.getEtat());
            existingVolMarchandise.setAeroportDepart(volMarchandise.getAeroportDepart());
            existingVolMarchandise.setAeroportDestination(volMarchandise.getAeroportDestination());
            existingVolMarchandise.setAvion(volMarchandise.getAvion());
            existingVolMarchandise.setEquipage(volMarchandise.getEquipage());
            // existingVolMarchandise.setAeroports(volMarchandise.getAeroports());
            existingVolMarchandise.setRestaurations(volMarchandise.getRestaurations());
    
            // Save the updated object
            return volMarchandiseRepository.save(existingVolMarchandise);
        } else {
            throw new NotFoundException("VolMarchandise not found with id: " + id);
        }
    }
    

    public void deleteVolMarchandise(Long id) throws NotFoundException {
        VolMarchandise existingVolMarchandise = volMarchandiseRepository.findById(id).orElse(null);
        if (existingVolMarchandise != null) {
            volMarchandiseRepository.delete(existingVolMarchandise);
        } else {
            throw new NotFoundException("VolMarchandise not found with id: " + id);
        }
    }
}
