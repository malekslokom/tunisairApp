package com.tunisair.service;


import com.tunisair.models.Aeroport;
import com.tunisair.models.Equipage;
import com.tunisair.models.Restauration;
import com.tunisair.models.VolMarchandise;
import com.tunisair.repositories.VolMarchandiseRepository;
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
public class VolMarchandiseService {


    private final VolMarchandiseRepository volMarchandiseRepository;
    private final RestaurationRepository restaurationRepository;
    private final AeroportRepository aeroportRepository;
    private final EquipageRepository equipageRepository;


    public VolMarchandiseService(VolMarchandiseRepository volMarchandiseRepository,
            RestaurationRepository restaurationRepository, AeroportRepository aeroportRepository,
            EquipageRepository equipageRepository) {
        this.volMarchandiseRepository = volMarchandiseRepository;
        this.restaurationRepository = restaurationRepository;
        this.aeroportRepository = aeroportRepository;
        this.equipageRepository = equipageRepository;
    }


    public List<VolMarchandise> getAllVolMarchandises() {
        return volMarchandiseRepository.findAll();
    }


    public VolMarchandise getVolMarchandiseById(Long id) throws NotFoundException {
        return volMarchandiseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vol Marchandise not found with id: " + id));
    }


    public VolMarchandise createVolMarchandise(VolMarchandise volMarchandise) {
        // Check if Aeroport Departure exists
        if (volMarchandise.getAeroportDepart() != null && volMarchandise.getAeroportDepart().getIdAeroport() != null) {
            Optional<Aeroport> aeroportDepartOptional = aeroportRepository
                    .findById(volMarchandise.getAeroportDepart().getIdAeroport());
            if (!aeroportDepartOptional.isPresent()) {
                System.out.println("!!!!!!! Aeroport Departure not found with id: "
                        + volMarchandise.getAeroportDepart().getIdAeroport());
            }
            volMarchandise.setAeroportDepart(aeroportDepartOptional.get());
        }


        // Check if Aeroport Destination exists
        if (volMarchandise.getAeroportDestination() != null
                && volMarchandise.getAeroportDestination().getIdAeroport() != null) {
            Optional<Aeroport> aeroportDestinationOptional = aeroportRepository
                    .findById(volMarchandise.getAeroportDestination().getIdAeroport());
            if (!aeroportDestinationOptional.isPresent()) {
                System.out.println("!!!!!!! Aeroport Destination not found with id: "
                        + volMarchandise.getAeroportDestination().getIdAeroport());
            }
            volMarchandise.setAeroportDestination(aeroportDestinationOptional.get());
        }


        // Check if Equipage exists
        if (volMarchandise.getEquipage() != null && volMarchandise.getEquipage().getIdEquipage() != null) {
            Optional<Equipage> equipageOptional = equipageRepository
                    .findById(volMarchandise.getEquipage().getIdEquipage());
            if (!equipageOptional.isPresent()) {
                System.out.println(
                        "!!!!!!! Equipage not found with id: " + volMarchandise.getEquipage().getIdEquipage());
            }
            volMarchandise.setEquipage(equipageOptional.get());
        }


        // Verify the existence of Restauration entities
        Set<Restauration> verifiedRestaurations = new HashSet<>();
        for (Restauration restauration : volMarchandise.getRestaurations()) {
            if (restauration.getIdRestauration() != null) {
                Optional<Restauration> restaurationOptional = restaurationRepository
                        .findById(restauration.getIdRestauration());
                if (!restaurationOptional.isPresent()) {
                    System.out.println(
                            "!!!!!!! Restauration not found with id: " + restauration.getIdRestauration());
                } else {
                    verifiedRestaurations.add(restaurationOptional.get());
                }
            }
        }
        volMarchandise.setRestaurations(verifiedRestaurations);


        // Save the VolMarchandise object
        return volMarchandiseRepository.save(volMarchandise);
    }


    public VolMarchandise updateVolMarchandise(Long id, VolMarchandise volMarchandise) throws NotFoundException {
        VolMarchandise existingVolMarchandise = volMarchandiseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vol Marchandise not found with id: " + id));


        // Update attributes of existingVolMarchandise with the new values from volMarchandise
        existingVolMarchandise.setDateDepart(volMarchandise.getDateDepart());
        existingVolMarchandise.setDateArrivee(volMarchandise.getDateArrivee());
        existingVolMarchandise.setRetard(volMarchandise.getRetard());
        existingVolMarchandise.setEtat(volMarchandise.getEtat());
        existingVolMarchandise.setAeroportDepart(volMarchandise.getAeroportDepart());
        existingVolMarchandise.setAeroportDestination(volMarchandise.getAeroportDestination());
        existingVolMarchandise.setAvion(volMarchandise.getAvion());
        existingVolMarchandise.setEquipage(volMarchandise.getEquipage());
        existingVolMarchandise.setRestaurations(volMarchandise.getRestaurations());
        existingVolMarchandise.setPoids(volMarchandise.getPoids());
        existingVolMarchandise.setTypeMarchandise(volMarchandise.getTypeMarchandise());


        return volMarchandiseRepository.save(existingVolMarchandise);
    }


    public void deleteVolMarchandise(Long id) throws NotFoundException {
        if (!volMarchandiseRepository.existsById(id)) {
            throw new NotFoundException("Vol Marchandise not found with id: " + id);
        }
        volMarchandiseRepository.deleteById(id);
    }
}
