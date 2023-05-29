package com.tunisair.service;

import com.tunisair.models.Restauration;
import com.tunisair.repositories.RestaurationRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RestaurationService {

    private final RestaurationRepository restaurationRepository;

    public RestaurationService(RestaurationRepository restaurationRepository) {
        this.restaurationRepository = restaurationRepository;
    }

    public Restauration getRestauration(Long id) throws NotFoundException {
        return restaurationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Restauration not found with id: " + id));
    }

    public Restauration createRestauration(Restauration restauration) {
        return restaurationRepository.save(restauration);
    }

    public Restauration updateRestauration(Long id, Restauration restauration) throws NotFoundException {
        Restauration existingRestauration = getRestauration(id);

        // Update attributes of existingRestauration with the new values from restauration
        existingRestauration.setNom(restauration.getNom());
        existingRestauration.setEmail(restauration.getEmail());
        existingRestauration.setTelephone(restauration.getTelephone());
        existingRestauration.setAdresse(restauration.getAdresse());
        existingRestauration.setTypecuisine(restauration.getTypecuisine());
        existingRestauration.setVols(restauration.getVols());

        return restaurationRepository.save(existingRestauration);
    }

    public void deleteRestauration(Long id) throws NotFoundException {
        Restauration existingRestauration = getRestauration(id);
        restaurationRepository.delete(existingRestauration);
    }
}
