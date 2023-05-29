package com.tunisair.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tunisair.models.*;
import com.tunisair.repositories.*;
@Service
public class AeroportService {

    @Autowired
    private AeroportRepository aeroportRepository;

    public List<Aeroport> getAllAeroports() {
        return aeroportRepository.findAll();
    }

    public Optional<Aeroport> getAeroportById(Long id) {
        return aeroportRepository.findById(id);
    }

    public Aeroport createAeroport(Aeroport aeroport) {
        return aeroportRepository.save(aeroport);
    }

    public Optional<Aeroport> updateAeroport(Long id, Aeroport updatedAeroport) {
        Optional<Aeroport> aeroport = aeroportRepository.findById(id);
        if (aeroport.isPresent()) {
            Aeroport existingAeroport = aeroport.get();
            existingAeroport.setNom(updatedAeroport.getNom());
            existingAeroport.setVille(updatedAeroport.getVille());
            // Update other properties as needed
            Aeroport savedAeroport = aeroportRepository.save(existingAeroport);
            return Optional.of(savedAeroport);
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteAeroport(Long id) {
        Optional<Aeroport> aeroport = aeroportRepository.findById(id);
        if (aeroport.isPresent()) {
            aeroportRepository.delete(aeroport.get());
            return true;
        } else {
            return false;
        }
    }
}
