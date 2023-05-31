package com.tunisair.service;

import com.tunisair.models.Aeroport;
import com.tunisair.models.Equipage;
import com.tunisair.models.Restauration;
import com.tunisair.models.Vol;
import com.tunisair.repositories.VolRepository;
import com.tunisair.repositories.AeroportRepository;
import com.tunisair.repositories.EquipageRepository;
import com.tunisair.repositories.RestaurationRepository;
import javassist.NotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class VolService {

    private final VolRepository volRepository;
    private final RestaurationRepository restaurationRepository;
    private final AeroportRepository aeroportRepository;
    private final EquipageRepository equipageRepository;

    public VolService(VolRepository volRepository, RestaurationRepository restaurationRepository,
            AeroportRepository aeroportRepository, EquipageRepository equipageRepository) {
        this.volRepository = volRepository;
        this.restaurationRepository = restaurationRepository;
        this.aeroportRepository = aeroportRepository;
        this.equipageRepository = equipageRepository;
    }

    public List<Vol> getAllVols() {
        return volRepository.findAll();
    }

    public Vol getVolById(Long id) throws NotFoundException {
        return volRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vol not found with id: " + id));
    }

    public Vol createVol(Vol vol) {

       
    if (vol.getAeroportDepart() != null && vol.getAeroportDepart().getIdAeroport() != null) {
        Optional<Aeroport> aeroportDepartOptional = aeroportRepository.findById(vol.getAeroportDepart().getIdAeroport());
        if (!aeroportDepartOptional.isPresent()) {

        }
        vol.setAeroportDepart(aeroportDepartOptional.get());
    }
    
    // Check if Aeroport Destination exists
    if (vol.getAeroportDestination() != null && vol.getAeroportDestination().getIdAeroport() != null) {
        Optional<Aeroport> aeroportDestinationOptional = aeroportRepository.findById(vol.getAeroportDestination().getIdAeroport());
        if (!aeroportDestinationOptional.isPresent()) {
           
        }
        vol.setAeroportDestination(aeroportDestinationOptional.get());
    }

    // Check if Equipage exists
    if (vol.getEquipage() != null && vol.getEquipage().getIdEquipage() != null) {
        Optional<Equipage> equipageOptional = equipageRepository.findById(vol.getEquipage().getIdEquipage());
        if (!equipageOptional.isPresent()) {

        }
       
        vol.setEquipage(equipageOptional.get());
    }
    // Verify the existence of Restauration entities

    Set<Restauration> verifiedRestaurations = new HashSet<>();
    for (Restauration restauration : vol.getRestaurations()) {

        if (restauration.getIdRestauration() != null) {
            Optional<Restauration> restaurationOptional = restaurationRepository.findById(restauration.getIdRestauration());
            if (!restaurationOptional.isPresent()) {

            } else {

                verifiedRestaurations.add(restaurationOptional.get());
            }
        }
    }
    vol.setRestaurations(verifiedRestaurations);
    // Save the Vol object
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
