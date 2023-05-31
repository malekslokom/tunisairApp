package com.tunisair.service;

import com.tunisair.models.VolVoyageur;
import com.tunisair.repositories.VolVoyageurRepository;

import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolVoyageurService {

    private final VolVoyageurRepository volVoyageurRepository;

    @Autowired
    public VolVoyageurService(VolVoyageurRepository volVoyageurRepository) {
        this.volVoyageurRepository = volVoyageurRepository;
    }

    public List<VolVoyageur> getAllVolVoyageurs() {
        return volVoyageurRepository.findAll();
    }

    public VolVoyageur getVolVoyageurById(Long id) {
        return volVoyageurRepository.findById(id).orElse(null);
    }

    public VolVoyageur createVolVoyageur(VolVoyageur volVoyageur) {
        return volVoyageurRepository.save(volVoyageur);
    }

    public VolVoyageur updateVolVoyageur(Long id, VolVoyageur updatedVolVoyageur) {
        VolVoyageur existingVolVoyageur = volVoyageurRepository.findById(id).orElse(null);
        if (existingVolVoyageur != null) {
            // Update the fields of the Vol entity
            existingVolVoyageur.setDateDepart(updatedVolVoyageur.getDateDepart());
            existingVolVoyageur.setDateArrivee(updatedVolVoyageur.getDateArrivee());
            existingVolVoyageur.setRetard(updatedVolVoyageur.getRetard());
            existingVolVoyageur.setEtat(updatedVolVoyageur.getEtat());
            existingVolVoyageur.setAeroportDepart(updatedVolVoyageur.getAeroportDepart());
            existingVolVoyageur.setAeroportDestination(updatedVolVoyageur.getAeroportDestination());
            existingVolVoyageur.setAvion(updatedVolVoyageur.getAvion());
            existingVolVoyageur.setEquipage(updatedVolVoyageur.getEquipage());
            // existingVolVoyageur.setAeroports(updatedVolVoyageur.getAeroports());
            existingVolVoyageur.setRestaurations(updatedVolVoyageur.getRestaurations());
    
            // Update the fields specific to VolVoyageur
            existingVolVoyageur.setNbPassagers(updatedVolVoyageur.getNbPassagers());
            existingVolVoyageur.setType(updatedVolVoyageur.getType());
    
            return volVoyageurRepository.save(existingVolVoyageur);
        } else {
            return null; // or throw an exception indicating that the entity was not found
        }
    }

    public boolean deleteVolVoyageur(Long id) throws NotFoundException {
        VolVoyageur existingVolVoyageur = volVoyageurRepository.findById(id).orElse(null);
        if (existingVolVoyageur != null) {
            volVoyageurRepository.delete(existingVolVoyageur);
            return true;
        } else {
            throw new NotFoundException("VolVoyageur not found with id: " + id);
        }
    }
    
    
}
