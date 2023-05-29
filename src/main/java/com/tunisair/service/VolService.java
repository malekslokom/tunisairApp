package com.tunisair.service;

import com.tunisair.models.Vol;
import com.tunisair.repositories.VolRepository;

import javassist.NotFoundException;

import org.springframework.stereotype.Service;

@Service
public class VolService {

    private final VolRepository volRepository;

    public VolService(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    public Vol getVolById(Long id) throws NotFoundException {
        return volRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vol not found with id: " + id));
    }

    public Vol createVol(Vol vol) {
        return volRepository.save(vol);
    }

    public Vol updateVol(Long id, Vol vol) throws NotFoundException {
        Vol existingVol = volRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vol not found with id: " + id));

        // Update attributes of existingVol with the new values from vol
        existingVol.setDateDepart(vol.getDateDepart());
        existingVol.setDateArrivee(vol.getDateArrivee());
        existingVol.setRetard(vol.getRetard());
        existingVol.setEtat(vol.getEtat());
        existingVol.setAeroportDepart(vol.getAeroportDepart());
        existingVol.setAeroportDestination(vol.getAeroportDestination());
        existingVol.setAvion(vol.getAvion());
        existingVol.setEquipage(vol.getEquipage());
        existingVol.setAeroports(vol.getAeroports());
        existingVol.setRestaurations(vol.getRestaurations());

        return volRepository.save(existingVol);
    }

    public void deleteVol(Long id) throws NotFoundException {
        if (!volRepository.existsById(id)) {
            throw new NotFoundException("Vol not found with id: " + id);
        }
        volRepository.deleteById(id);
    }
}