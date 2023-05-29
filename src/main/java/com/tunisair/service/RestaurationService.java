package com.tunisair.service;

import com.tunisair.models.Restauration;
import com.tunisair.repositories.RestaurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurationService {
    private final RestaurationRepository restaurationRepository;

    @Autowired
    public RestaurationService(RestaurationRepository restaurationRepository) {
        this.restaurationRepository = restaurationRepository;
    }

    public List<Restauration> getAllRestaurations() {
        return restaurationRepository.findAll();
    }

    public Restauration getRestaurationById(Long id) {
        return restaurationRepository.findById(id).orElse(null);
    }

    public Restauration saveRestauration(Restauration restauration) {
        return restaurationRepository.save(restauration);
    }

    public Restauration updateRestauration(Long id, Restauration restauration) {
        Restauration existingRestauration = restaurationRepository.findById(id).orElse(null);
        if (existingRestauration != null) {
            existingRestauration.setNom(restauration.getNom());
            existingRestauration.setEmail(restauration.getEmail());
            existingRestauration.setTelephone(restauration.getTelephone());
            existingRestauration.setAdresse(restauration.getAdresse());
            existingRestauration.setTypecuisine(restauration.getTypecuisine());
            existingRestauration.setVols(restauration.getVols());
            // Save the updated restauration
            return restaurationRepository.save(existingRestauration);
        }
        return null;
    }

    public void deleteRestaurationById(Long id) {
        restaurationRepository.deleteById(id);
    }
}
