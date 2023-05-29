package com.tunisair.service;

import com.tunisair.models.Escale;
import com.tunisair.repositories.EscaleRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EscaleService {

    private final EscaleRepository escaleRepository;

    public EscaleService(EscaleRepository escaleRepository) {
        this.escaleRepository = escaleRepository;
    }

    public Escale getEscaleById(Long id) throws NotFoundException {
        return escaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Escale not found with id: " + id));
    }

    public Escale createEscale(Escale escale) {
        return escaleRepository.save(escale);
    }

    public Escale updateEscale(Long id, Escale escale) throws NotFoundException {
        Escale existingEscale = escaleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Escale not found with id: " + id));

        // Update attributes of existingEscale with the new values from escale
        existingEscale.setVol(escale.getVol());
        existingEscale.setAeroport(escale.getAeroport());

        return escaleRepository.save(existingEscale);
    }

    public void deleteEscale(Long id) throws NotFoundException {
        if (!escaleRepository.existsById(id)) {
            throw new NotFoundException("Escale not found with id: " + id);
        }
        escaleRepository.deleteById(id);
    }
}
